package com.kasbino.bootcamp.exception.custom;

public class DuplicateAdminException extends RuntimeException {

    public DuplicateAdminException(String message) {
        super(message);
    }
}
