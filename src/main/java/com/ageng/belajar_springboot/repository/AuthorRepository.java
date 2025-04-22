package com.ageng.belajar_springboot.repository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ageng.belajar_springboot.domain.Author;

// import jakarta.persistence.EntityManager;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // @Autowired
    // private EntityManager em;

    // public void save(Author author) {
    // em.persist(author);
    // }

}
