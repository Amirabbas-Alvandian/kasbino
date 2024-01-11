package com.kasbino.bootcamp.exception.custom;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message) {
        super(message);
    }
}
