package com.ageng.belajar_springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public void uploadFile(MultipartFile file) throws Exception;
}
