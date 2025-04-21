package com.ageng.belajar_springboot.service;

import java.util.List;

import com.ageng.belajar_springboot.dto.AuthorDTO;

public interface AuthorService {
    public void saveAuthor(AuthorDTO authorDTO);

    public List<AuthorDTO> getAllAuthors();

}
