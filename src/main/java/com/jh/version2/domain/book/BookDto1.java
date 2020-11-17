package com.jh.version2.domain.book;

import lombok.Builder;
import lombok.Data;

@Data
public class BookDto1 {

    private Long bookId;
    private String bookName;
    private Integer bookPrice;

    @Builder
    public BookDto1 (Book book) {
        this.bookId = book.getId();
        this.bookName = book.getName();
        this.bookPrice = book.getPrice();
    }

    public static BookDto1 of (Book book) {
        return BookDto1.builder().book(book).build();
    }

}
