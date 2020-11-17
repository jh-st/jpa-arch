package com.jh.version2.domain.store;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.book.Book;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Book> books;

    //@JsonIgnore
    //@JsonManagedReference

}
