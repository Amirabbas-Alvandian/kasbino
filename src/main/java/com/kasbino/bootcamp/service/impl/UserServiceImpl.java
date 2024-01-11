package com.kasbino.bootcamp.service.impl;

import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.exception.custom.DuplicateUserException;
import com.kasbino.bootcamp.mapper.UserMapper;
import com.kasbino.bootcamp.repository.UserRepository;
import com.kasbino.bootcamp.service.UserService;
import com.kasbino.bootcamp.service.base.impl.BaseServiceImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User dtoToModel(UserRequestDto requestDto) {
        return UserMapper.INSTANCE.dtoToModel(requestDto);
    }

    @Override
    public UserResponseDto modelToDto(User user) {
        return UserMapper.INSTANCE.modelToDto(user);
    }

    @Override
    public User customSave(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved;
        try {
            saved = save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException(e.getMessage());
        }
        return saved;
    }
}
