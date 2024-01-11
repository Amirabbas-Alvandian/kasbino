package com.kasbino.bootcamp.service;

import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.service.base.BaseService;

public interface UserService extends BaseService<User,Long> {

    User dtoToModel(UserRequestDto requestDto);

    UserResponseDto modelToDto(User user);

    User customSave(User user);
}
