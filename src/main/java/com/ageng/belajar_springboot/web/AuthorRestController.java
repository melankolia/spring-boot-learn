package com.ageng.belajar_springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.ageng.belajar_springboot.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ageng.belajar_springboot.dto.AuthorDTO;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    // public AuthorRestController(AuthorService authorService) {
    // this.authorService = authorService;
    // }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(@RequestParam(required = false) String name) {
        List<AuthorDTO> authors = authorService.getAllAuthors(name);
        return ResponseEntity.ok(authors);
    }

}
