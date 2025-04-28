package com.ageng.belajar_springboot.repository;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ageng.belajar_springboot.domain.Author;

// import jakarta.persistence.EntityManager;

/**
 * Documentation:
 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
 * 
 */

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // @Autowired
    // private EntityManager em;

    // public void save(Author author) {
    // em.persist(author);
    // }

    // method name -> sql spring data jpa
    public List<Author> findByName(String name); // select * from t_author where name = ?

    public List<Author> findByNameIgnoreCase(String name); // select * from t_author where name = ? and description = ?

    // jpql (jakarta persistence query language)
    // SQL Native Query
    // criteria api
    // Hibernate Scratch
}
