package com.ageng.belajar_springboot.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ageng.belajar_springboot.config.MinioProperties;
import com.ageng.belajar_springboot.service.FileService;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

@Service
public class FileServiceImpl implements FileService {
    private final MinioClient minioClient;

    private final MinioProperties minioProperties;

    public FileServiceImpl(MinioClient minioClient, MinioProperties minioProperties) {
        this.minioClient = minioClient;
        this.minioProperties = minioProperties;
    }

    @Override
    public void uploadFile(MultipartFile file) throws Exception {
        minioClient
                .putObject(PutObjectArgs.builder().bucket(minioProperties.getBucket())
                        .object(file.getOriginalFilename())
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType("video/mp4")
                        .build());
    }
}
