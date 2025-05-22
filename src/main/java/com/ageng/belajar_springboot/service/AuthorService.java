package com.ageng.belajar_springboot.service;

import java.util.List;

import com.ageng.belajar_springboot.domain.Author;
import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.dto.ResultPageResponseDTO;

public interface AuthorService {
    public Author saveAuthor(AuthorDTO authorDTO);

    public List<AuthorDTO> getAllAuthors(String name);

    public ResultPageResponseDTO<AuthorDTO> findAuthors(
            Integer pages,
            Integer limit,
            String sortBy,
            String direction,
            String authorName);
}
