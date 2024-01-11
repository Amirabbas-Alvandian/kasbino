package com.kasbino.bootcamp.service.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T,R> {

    T save(T t);
    Optional<T> findById(R id);
    List<T> findAll();
}
