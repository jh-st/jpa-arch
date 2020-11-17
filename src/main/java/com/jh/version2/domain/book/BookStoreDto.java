package com.jh.version2.domain.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.store.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BookStoreDto {

    private Long storeId;
    private String storeName;

    //@OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    //private List<Book> books;

    //@JsonIgnore
    //@JsonManagedReference

    @Builder
    public BookStoreDto(Store store) {
        this.storeId = store.getId();
        this.storeName = store.getName();
    }

    public static BookStoreDto of (Store store) {
        return BookStoreDto.builder().store(store).build();
    }

}
