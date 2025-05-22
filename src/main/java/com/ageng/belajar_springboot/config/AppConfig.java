package com.ageng.belajar_springboot.config;

import com.ageng.belajar_springboot.Author;
import com.ageng.belajar_springboot.Book;

import io.minio.MinioClient;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.mail.*;

@ComponentScan(basePackages = { "com.ageng.belajar_springboot" })
@Configuration
public class AppConfig {

    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);

        author.setName("Ageng Armstrong");

        return author;
    };

    @Bean
    public Book book1(@Qualifier("author1") Author author) {
        Book book = new Book("Who wrote holden Caulfield", author);
        return book;
    }

    @Bean
    public Properties mailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "587");

        return prop;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("8ccb79ba485335", "e4c31e44a04480");
    }

    // Dari sini bagaimana dia tau ini yg diinject ke EmailService
    @Bean
    public Session mailSession(
            @Qualifier("mailProperties") Properties mailProperties,
            PasswordAuthentication authentication) {

        Session session = Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return authentication;
            }
        });
        return session;
    }

    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(properties.getUrl())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
        return minioClient;
    }
}