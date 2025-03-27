package com.ageng.belajar_springboot.web;

import com.ageng.belajar_springboot.config.ApplicationProperties;
import com.ageng.belajar_springboot.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// is Short for @Controller and @ResponseBody
@RestController
@RequestMapping("/v1/hello")
public class HelloResource {

    private final EmailService emailService;
    private ApplicationProperties properties;

    // inject value from application.properties
    @Value("${test.name}")
    private String name;

    // ApplicationProperties got from config/ApplicationProperties.java
    HelloResource(EmailService emailService, ApplicationProperties properties) {
        this.emailService = emailService;
        this.properties = properties;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String requestMethodName() {
        return "hello";
    }

    @GetMapping("/name")
    public String getName() {
        return properties.getName() + " - " + properties.getCurrency();
    }

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String sentEmail() {
        try {
            emailService.sendMail();

            System.out.println("Email sent successfully");
            return "Email sent successfully";
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
    }

    // @Autowired
    // public void setProperties(ApplicationProperties properties) {
    // this.properties = properties;
    // }

}
