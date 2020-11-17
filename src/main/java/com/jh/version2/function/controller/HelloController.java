package com.jh.version2.function.controller;

import com.jh.version2.domain.book.*;
import com.jh.version2.domain.store.Store;
import com.jh.version2.domain.store.StoreDto;
import com.jh.version2.domain.store.StoreService;
import com.jh.version2.domain.team.repository.TeamRepository;
import com.jh.version2.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    BookService bookService;

    @Autowired
    StoreService storeService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/book")
    public Book book() {
        Book book1 = entityManager.find(Book.class, 1L);
        Book book2 = entityManager.getReference(Book.class, 1L);

        System.out.println("book2.getStore().getClass() = " + book2.getStore().getClass());

        return book2;
    }

    /*@GetMapping(value = "/book1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<BookDto1> book1() {
        BookDto1 bookDto1 = bookService.book11();
        return ResponseUtil.getResult(bookDto1);
    }*/

    @GetMapping("/book1")
    public BookDto1 book1() {
        return bookService.book11();
    }

    @GetMapping("/book2")
    public BookDto2 book2() {
        return bookService.book22();
    }

    @GetMapping("/book3")
    public BookDto book3() {
        return bookService.book33();
    }

    @GetMapping("/book4")
    public BookDto book4() {
        return bookService.book44();
    }

    @GetMapping("/store")
    public Store store() {
        return entityManager.find(Store.class, 1L);
    }

    @GetMapping("/store1")
    public StoreDto store1() {
        return storeService.store1();
    }

    @GetMapping("/store2")
    public StoreDto store2() {
        return storeService.store2();
    }

    @GetMapping("/stores1")
    public List<StoreDto> stores1() {
        return storeService.stores1();
    }

    @GetMapping("/stores2")
    public List<StoreDto> stores2() {
        return storeService.stores2();
    }
}
