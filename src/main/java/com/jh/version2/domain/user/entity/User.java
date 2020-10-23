package com.jh.version2.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.version2.domain.team.entity.Team;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter @Setter
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
    public User(String name, Integer age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void update(Integer age, Team team) {
        this.age = age;
        this.team = team;
    }

}
