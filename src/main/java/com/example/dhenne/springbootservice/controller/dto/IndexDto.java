package com.example.dhenne.springbootservice.controller.dto;

import lombok.Builder;

@Builder
public record IndexDto(
        String message,
        String environment,
        String globalParam1,
        String localParam2
) {
}
