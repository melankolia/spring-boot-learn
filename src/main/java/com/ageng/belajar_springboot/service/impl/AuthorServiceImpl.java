package com.ageng.belajar_springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ageng.belajar_springboot.domain.Author;
import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.dto.ResultPageResponseDTO;
import com.ageng.belajar_springboot.repository.AuthorRepository;
import com.ageng.belajar_springboot.service.AuthorService;
import com.ageng.belajar_springboot.util.PaginationUtil;

import org.springframework.util.StringUtils;

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

    @Override
    public ResultPageResponseDTO<AuthorDTO> findAuthors(
            Integer pages,
            Integer limit,
            String sortBy,
            String direction,
            String authorName) {

        authorName = StringUtils.hasText(authorName) ? authorName + "%" : "%";

        Direction direc = PaginationUtil.getSortDirection(direction);
        Pageable pageable = PageRequest.of(pages, limit, Sort.by(new Sort.Order(direc, sortBy)));

        Page<Author> authors = authorRepository.findByNameLikeIgnoreCase(authorName, pageable);

        authors.forEach(author -> {
            System.out.println("Author Name: " + author.getName() + ", Description: " + author.getDescription());
        });

        List<AuthorDTO> authorDTOs = authors.stream().map((a) -> {
            System.out.println(a.getName());
            return new AuthorDTO(a.getName(), a.getDescription());
        }).collect(Collectors.toList());

        return new ResultPageResponseDTO<>(authorDTOs, authors.getTotalPages(), authors.getTotalElements());
    }
}