package com.jh.version2.domain.book;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookDto2 {

    private Long bookId;
    private String bookName;
    private Integer bookPrice;
    private BookStoreDto storeDto;

    @Builder
    public BookDto2(Book book) {
        this.bookId = book.getId();
        this.bookName = book.getName();
        this.bookPrice = book.getPrice();
        this.storeDto = BookStoreDto.of(book.getStore());
    }

    public static BookDto2 of (Book book) {
        return BookDto2.builder().book(book).build();
    }

}
