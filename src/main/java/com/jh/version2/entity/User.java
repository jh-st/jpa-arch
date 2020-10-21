package com.jh.version2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @Builder
    public User (String name, Integer age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void update(Integer age, Team team) {
        this.age = age;
        this.team = team;
    }

}
