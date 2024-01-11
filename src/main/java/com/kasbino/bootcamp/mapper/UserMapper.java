package com.kasbino.bootcamp.mapper;

import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToModel(UserRequestDto requestDto);

    UserResponseDto modelToDto(User user);
}
