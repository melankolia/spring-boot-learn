package com.ageng.belajar_springboot.dto;

import java.util.List;

public record ErrorMessageDTO(
                Integer code, List<String> message) {
}
