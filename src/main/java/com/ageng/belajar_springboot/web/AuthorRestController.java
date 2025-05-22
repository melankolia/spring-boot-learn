package com.ageng.belajar_springboot.web;

import com.ageng.belajar_springboot.domain.Author;
import org.springframework.web.bind.annotation.*;

import com.ageng.belajar_springboot.service.AuthorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.dto.ResultPageResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    // public AuthorRestController(AuthorService authorService) {
    // this.authorService = authorService;
    // }

    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody @Valid AuthorDTO authorDTO) {
        authorService.saveAuthor(authorDTO);
        return ResponseEntity.ok(authorDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(@RequestParam(required = false) String name) {
        List<AuthorDTO> authors = authorService.getAllAuthors(name);
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/page")
    public ResponseEntity<ResultPageResponseDTO<AuthorDTO>> findAthorsPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction,
            @RequestParam(name = "authorName", defaultValue = "") String authorName) {

        return ResponseEntity.ok(authorService.findAuthors(pages, limit, sortBy, direction, authorName));

    }
}
