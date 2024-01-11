package com.kasbino.bootcamp.controller;

import com.kasbino.bootcamp.dto.request.AdminRequestDto;
import com.kasbino.bootcamp.dto.request.UserRequestDto;
import com.kasbino.bootcamp.dto.response.AdminResponseDto;
import com.kasbino.bootcamp.dto.response.UserResponseDto;
import com.kasbino.bootcamp.entity.Admin;
import com.kasbino.bootcamp.entity.User;
import com.kasbino.bootcamp.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("/add-user")
    public ResponseEntity<UserResponseDto> addUser (@RequestBody UserRequestDto requestDto){

        User user = service.addUser(service.recieveAndMapUser(requestDto));

        return new ResponseEntity<>(service.mapAndReturnUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<AdminResponseDto> registerAdmin(@RequestBody AdminRequestDto requestDto){

        System.out.println(requestDto);
        Admin admin = service.customSave(service.dtoToModel(requestDto));

        return new ResponseEntity<>(service.modelToDto(admin), HttpStatus.CREATED);

    }
}
