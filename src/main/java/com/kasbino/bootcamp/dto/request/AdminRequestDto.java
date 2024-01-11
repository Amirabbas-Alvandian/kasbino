package com.kasbino.bootcamp.dto.request;

public record AdminRequestDto(
                              String name,
                              String lastname,
                              String username,
                              String password) {
}