package com.jh.version2.domain.store;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StoreDto {

    private Long storeId;
    private String storeName;
    private List<StoreBookDto> books;

    @Builder
    public StoreDto (Store store, boolean... isShow) {
        this.storeId = store.getId();
        this.storeName = store.getName();
        if(isShow[0]) this.books = StoreBookDto.list(store.getBooks());
    }

    public static StoreDto of (Store store, boolean... isShow) {
        return StoreDto.builder()
                .store(store)
                .isShow(isShow)
                .build();
    }

    public static List<StoreDto> list1 (List<Store> store) {
        return store.stream().map(o -> StoreDto.of(o, false)).collect(Collectors.toList());
    }

    public static List<StoreDto> list2 (List<Store> store) {
        return store.stream().map(o -> StoreDto.of(o, true)).collect(Collectors.toList());
    }

}
