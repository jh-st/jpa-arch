package com.jh.version2.domain.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BookService {

    @Autowired
    EntityManager em;

    @Autowired
    BookRepository bookRepository;

    public BookDto1 book1() {
        return BookDto1.of(em.find(Book.class, 1L));
    }

    public BookDto2 book2() {
        return BookDto2.of(em.find(Book.class, 1L));
    }

    public BookDto1 book11() {
        return BookDto1.of(bookRepository.findById(1L).get());
    }

    public BookDto2 book22() {
        return BookDto2.of(bookRepository.findById(1L).get());
    }

    public BookDto book33() {
        return BookDto.of(bookRepository.findById(1L).get(), false, false);
    }

    public BookDto book44() {
        return BookDto.of(bookRepository.findById(1L).get(), true, true);
    }

}
