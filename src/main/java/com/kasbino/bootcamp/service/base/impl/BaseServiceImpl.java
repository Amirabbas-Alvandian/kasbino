package com.kasbino.bootcamp.service.base.impl;

import com.kasbino.bootcamp.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl <T,R> implements BaseService<T,R> {

    private final JpaRepository<T,R> repository;

    public BaseServiceImpl(JpaRepository<T, R> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Optional<T> findById(R id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
