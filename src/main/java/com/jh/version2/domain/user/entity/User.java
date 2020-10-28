package com.jh.version2.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.version2.common.dto.variable.Level;
import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.common.entity.Base;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.user.dto.UserApplyDto;
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

    @Enumerated(value = EnumType.STRING)
    @Column(name = "LEVEL")
    private Level level;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @Builder
    public User(
            String name
            , Integer age
            , Role role
            , Level level
            , Team team) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.level = level;
        this.team = team;
    }

    public User update(UserApplyDto applyDto, Team team) {
        this.age = applyDto.getUserAge();
        this.team = team;
        return this;
    }

    public User updateRole(Role role) {
        this.role = role;
        return this;
    }

}
