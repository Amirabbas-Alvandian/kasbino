package com.kasbino.bootcamp.repository.jdbc.actuals.impl;

import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.repository.jdbc.base.Impl.BaseRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcRepositoryImpl extends BaseRepositoryImpl<Long, User> {
    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public String getColumnsName() {
        return "(name, lastname, username, password)";
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return null;
    }

    @Override
    public User mapResultSetTOEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, User entity) throws SQLException {
        preparedStatement.setString(1,entity.getName());
        preparedStatement.setString(2,entity.getLastname());
        preparedStatement.setString(3,entity.getUsername());
        preparedStatement.setString(4,entity.getUsername());
    }

    @Override
    public Long getGeneratedId(ResultSet resultSet) throws SQLException {
        return null;
    }
}
