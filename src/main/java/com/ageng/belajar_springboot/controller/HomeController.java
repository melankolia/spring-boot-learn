package com.ageng.belajar_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(@RequestParam(value = "Default Name", required = false) String name, Model model) {
        model.addAttribute("name", "Ageng");
        return "home";
    }

}
