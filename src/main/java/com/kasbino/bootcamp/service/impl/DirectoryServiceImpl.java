package com.kasbino.bootcamp.service.impl;

import com.kasbino.bootcamp.service.DirectoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DirectoryServiceImpl implements DirectoryService {


    private String address = "C:\\Users\\Alvandian\\IdeaProjects\\adak\\bootcamp\\src\\main\\resources\\folders\\";

    @Override
    public boolean createDirectory(String name) {
        return new File(address + name).mkdir();
    }
}
