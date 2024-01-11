package com.kasbino.bootcamp.repository.jdbc.base;

import com.kasbino.bootcamp.entity.Person;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository <ID extends Serializable , TYPE extends Person> {

    ID save (TYPE entity);

    int update (TYPE entity);

    int delete (ID id);

    TYPE findByID (ID id);

    List<TYPE> findAll ();
}
