package com.jh.version2.domain.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.store.Notebook;
import com.jh.version2.domain.store.Store;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notebook notebook;

}
