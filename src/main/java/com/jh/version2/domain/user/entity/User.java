package com.jh.version2.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.common.entity.Base;
import com.jh.version2.domain.team.entity.Team;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class User extends Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @Builder
    public User(String name, Integer age, Role role, Team team) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.team = team;
    }

    public void update(Integer age, Team team) {
        this.age = age;
        this.team = team;
    }

    public void updateRole(Role role) {
        this.role = role;
    }

}
