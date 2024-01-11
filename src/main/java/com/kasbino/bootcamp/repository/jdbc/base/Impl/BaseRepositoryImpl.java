
package com.kasbino.bootcamp.repository.jdbc.base.Impl;
import com.kasbino.bootcamp.config.DBConfig;
import com.kasbino.bootcamp.entity.Person;
import com.kasbino.bootcamp.repository.jdbc.base.BaseRepository;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpl<ID extends Serializable ,  TYPE extends Person> implements BaseRepository<ID,TYPE> {


    @Override
    public ID save(TYPE entity)  {
        // insert into table_name (column names) values (?,?,?);
        String insertSql = "INSERT INTO " + getTableName() + " " +
                getColumnsName() +
                "VALUES (" + getCountOfQuestionMarkForParams() + ")";

        try (PreparedStatement preparedStatement = new DBConfig().getConnection().prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            fillParamForStatement(preparedStatement , entity );
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return getGeneratedId(resultSet);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int update(TYPE entity)  {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateQueryParams() + " WHERE id = ?";
        try (PreparedStatement statement = new DBConfig().getConnection().prepareStatement(sql)) {
            fillParamForStatement(statement, entity);
            return statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public int delete(ID id)  {
        String deleteSQL = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement preparedStatement = new DBConfig().getConnection().prepareStatement(deleteSQL)){
            preparedStatement.setInt(1,(Integer) id);
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public TYPE findByID(ID id) {
        String selectSQL = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement preparedStatement = new DBConfig().getConnection().prepareStatement(selectSQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY)){
            preparedStatement.setInt(1, (Integer) id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return mapResultSetTOEntity(resultSet);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<TYPE> findAll() {
        String loadAllSQl = "SELECT * FROM " + getTableName() ;
        try (PreparedStatement preparedStatement = new DBConfig().getConnection().prepareStatement(loadAllSQl)){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TYPE> entities = new ArrayList<>();
            while (resultSet.next()){
                entities.add(mapResultSetTOEntity(resultSet));
            }
            return entities;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }




    public abstract String getTableName ();
    public abstract String getColumnsName ();
    public abstract String getUpdateQueryParams();
    public abstract String getCountOfQuestionMarkForParams();
    public abstract TYPE mapResultSetTOEntity (ResultSet resultSet) throws SQLException;
    public abstract void fillParamForStatement(PreparedStatement preparedStatement,TYPE entity) throws SQLException;
    public abstract ID getGeneratedId (ResultSet resultSet) throws SQLException;
}


