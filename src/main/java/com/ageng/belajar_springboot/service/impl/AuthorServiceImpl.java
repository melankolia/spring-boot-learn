package com.ageng.belajar_springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    List<AuthorDTO> authors = new ArrayList<>();

    @Override
    public void saveAuthor(AuthorDTO authorDTO) {
        authors.add(authorDTO);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authors;
    }
}