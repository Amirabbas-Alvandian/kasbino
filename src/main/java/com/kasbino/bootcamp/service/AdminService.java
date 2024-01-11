package com.kasbino.bootcamp.service;

import com.kasbino.bootcamp.dto.request.AdminRequestDto;
import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.AdminResponseDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.Admin;
import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.service.base.BaseService;

import java.util.Optional;

public interface AdminService extends BaseService<Admin,Long> {

    User addUser (User user);

    UserResponseDto mapAndReturnUser(User user);

    User recieveAndMapUser(UserRequestDto requestDto);

    Admin dtoToModel(AdminRequestDto requestDto);

    AdminResponseDto modelToDto(Admin admin);
    Admin findByUsername(String username);

    Admin customSave(Admin admin);
}
