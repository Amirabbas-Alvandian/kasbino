package com.kasbino.bootcamp.controller;

import com.kasbino.bootcamp.service.DirectoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directory")
public class DirectoryController {

    private final DirectoryService directoryService;

    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createDirectory(@RequestBody String name){

        return new ResponseEntity<>(directoryService.createDirectory(name), HttpStatus.OK);
    }
    @PostMapping("/create-pb")
    public ResponseEntity<Boolean> createDirectoryPB(@RequestBody String name){

        return new ResponseEntity<>(directoryService.createDirectoryPB(name), HttpStatus.OK);
    }
}
