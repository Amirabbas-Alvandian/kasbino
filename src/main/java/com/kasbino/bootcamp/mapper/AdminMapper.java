package com.kasbino.bootcamp.mapper;

import com.kasbino.bootcamp.dto.request.AdminRequestDto;
import com.kasbino.bootcamp.dto.response.AdminResponseDto;
import com.kasbino.bootcamp.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin dtoToModel(AdminRequestDto requestDto);

    AdminResponseDto modelToDto(Admin admin);
}
