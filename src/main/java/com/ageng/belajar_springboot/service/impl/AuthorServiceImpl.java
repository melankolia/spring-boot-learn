package com.ageng.belajar_springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ageng.belajar_springboot.domain.Author;
import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.repository.AuthorRepository;
import com.ageng.belajar_springboot.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    List<AuthorDTO> authors = new ArrayList<>();

    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.name());
        author.setDescription(authorDTO.description());

        return authorRepository.save(author);
    }

    // @Override
    // public List<AuthorDTO> getAllAuthors() {
    // return authors;
    // }

    @Override
    public List<AuthorDTO> getAllAuthors(String name) {
        // List<AuthorDTO> authors = new ArrayList<>();
        // System.out.println(authorRepository.findByName("Ageng"));
        // System.out.println(authorRepository.findByNameIgnoreCase("A%"));

        List<Author> authors = authorRepository.findAll();
        return authors.stream().map((a) -> {
            return new AuthorDTO(a.getName(), a.getDescription());
        }).collect(Collectors.toList());

        // return authors;
    }
}