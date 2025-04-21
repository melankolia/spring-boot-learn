package com.ageng.belajar_springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ageng.belajar_springboot.dto.AuthorDTO;
import com.ageng.belajar_springboot.dto.BreadCrumbItem;
import com.ageng.belajar_springboot.service.AuthorService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    // Ada 2 Cara untuk return response html
    // 1. Menggunakan Thymeleaf (Render Ketika Runtime)
    // 2. Menggunakan JTE (Render Ketika Compile)

    // Styling nya bisa pake HTMX Bootify
    // Bisa juga pake Tailwind CSS
    // Bisa diembed di HTML <head>

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("new")
    public String getMethodName(Model model) {
        model.addAttribute("authorDTO", new AuthorDTO(null, null));
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author Create", "/authors/new")));
        return "author/create-author";
    }

    // Add RedirectAttributes to pass data to the next request
    @PostMapping("new")
    public String postMethodName(@ModelAttribute AuthorDTO authorDTO, Model model, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("authorDTO", authorDTO);
        this.authorService.saveAuthor(authorDTO);

        return "redirect:/authors/result";
    }

    @GetMapping("result")
    public String displayResult(@ModelAttribute AuthorDTO authorDTO, Model model) {

        model.addAttribute("authorDTO", authorDTO);
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author Create", "/authors/new"),
                new BreadCrumbItem("Result", "/authors/result")));
        return "author/author-result";
    }

    @GetMapping("list")
    public String getListAuthor(Model model) {

        List<AuthorDTO> authors = this.authorService.getAllAuthors();

        model.addAttribute("authors", authors);
        model.addAttribute("breadcrumb", List.of(
                new BreadCrumbItem("Home", "/authors/list"),
                new BreadCrumbItem("Author List", "/authors/list")));
        return "author/author-list";
    }
}
