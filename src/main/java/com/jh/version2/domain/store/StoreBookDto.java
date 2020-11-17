package com.jh.version2.domain.store;

import com.jh.version2.domain.book.Book;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StoreBookDto {

    private Long bookId;
    private String bookName;
    private Integer bookPrice;

    @Builder
    public StoreBookDto(Book book) {
        this.bookId = book.getId();
        this.bookName = book.getName();
        this.bookPrice = book.getPrice();
    }

    public static StoreBookDto of(Book book) {
        return StoreBookDto.builder()
                .book(book)
                .build();
    }

    public static List<StoreBookDto> list(List<Book> book) {
        if (ObjectUtils.isEmpty(book)) {
            return null;
        }

        return book.stream()
                .map(StoreBookDto::of)
                .collect(Collectors.toList());
    }

}
