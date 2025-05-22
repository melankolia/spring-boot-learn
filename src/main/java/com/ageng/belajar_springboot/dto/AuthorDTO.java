package com.ageng.belajar_springboot.dto;

import com.ageng.belajar_springboot.validation.anotation.ValidName;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDTO(
        @NotBlank @Size(min = 5, max = 20) @ValidName String name,
        String description) {
}