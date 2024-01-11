package com.kasbino.bootcamp.service.impl;

import com.kasbino.bootcamp.dto.request.AdminRequestDto;
import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.AdminResponseDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.Admin;
import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.exception.custom.DuplicateUserException;
import com.kasbino.bootcamp.mapper.AdminMapper;
import com.kasbino.bootcamp.repository.AdminRepository;
import com.kasbino.bootcamp.service.UserService;
import com.kasbino.bootcamp.service.base.impl.BaseServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin,Long> implements com.kasbino.bootcamp.service.AdminService {

    private final AdminRepository repository;

    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository repository, UserService userService, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        return userService.customSave(user);
    }

    @Override
    public UserResponseDto mapAndReturnUser(User user) {
        return userService.modelToDto(user);
    }

    @Override
    public User recieveAndMapUser(UserRequestDto requestDto) {
        return userService.dtoToModel(requestDto);
    }

    @Override
    public Admin dtoToModel(AdminRequestDto requestDto) {
        return AdminMapper.INSTANCE.dtoToModel(requestDto);
    }

    @Override
    public AdminResponseDto modelToDto(Admin admin) {
        return AdminMapper.INSTANCE.modelToDto(admin);
    }

    @Override
    public Admin findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(
                () ->  new EntityNotFoundException("user with " +username + "not found")
        );
    }

    @Override
    public Admin customSave(Admin admin) {
        System.out.println(admin);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Admin saved;
        try {
            saved = save(admin);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException(e.getMessage());
        }
        return saved;
    }
}
