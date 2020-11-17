package com.jh.version2.domain.book;

import com.jh.version2.domain.store.NotebookDto;
import lombok.Builder;
import lombok.Getter;

@Getter
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookDto {

    private Long bookId;
    private String bookName;
    private Integer bookPrice;
    private BookStoreDto store;
    private NotebookDto notebook;

    @Builder
    public BookDto(Book book, boolean... isShow) {
        this.bookId = book.getId();
        this.bookName = book.getName();
        this.bookPrice = book.getPrice();
        if(isShow[0]) this.store = BookStoreDto.of(book.getStore());
        if(isShow[1]) this.notebook = NotebookDto.of(book.getNotebook());
    }

    public static BookDto of (Book book, boolean... isShow) {
        return BookDto.builder()
                .book(book)
                .isShow(isShow)
                .build();
    }

}
