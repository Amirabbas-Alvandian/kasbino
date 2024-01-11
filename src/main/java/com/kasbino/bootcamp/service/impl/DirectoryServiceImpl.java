package com.kasbino.bootcamp.service.impl;

import com.kasbino.bootcamp.service.DirectoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DirectoryServiceImpl implements DirectoryService {


    private String address = "C:\\Users\\Alvandian\\IdeaProjects\\adak\\bootcamp\\src\\main\\resources\\folders";

    @Override
    public boolean createDirectory(String name) {
        return new File(address + "\\" +name).mkdir();
    }

    @Override
    public boolean createDirectoryPB(String name) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();

            processBuilder.directory(new File("C:\\Users\\Alvandian\\IdeaProjects\\adak\\bootcamp\\src\\main\\resources\\folders"));
            processBuilder.command("cmd","/c","mkdir", name);
            System.out.println(processBuilder.directory().toString());

            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Failed to create directory");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

