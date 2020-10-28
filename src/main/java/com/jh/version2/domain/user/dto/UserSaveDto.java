package com.jh.version2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.version2.common.dto.variable.Level;
import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.user.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSaveDto {

    private String userName;
    private Integer userAge;
    private Role userRole;
    private Level userLevel;
    private Long teamId;

    @JsonIgnore
    private Team team;

    @Builder
    public UserSaveDto (
            final String userName
            , final Integer userAge
            , final Role userRole
            , final Level userLevel
            , final Long teamId
    ) {
        this.userName = userName;
        this.userAge = userAge;
        this.userRole = userRole;
        this.userLevel = userLevel;
        this.teamId = teamId;
    }

    public User toEntity() {
        return User.builder()
                .name(this.userName)
                .age(this.userAge)
                .role(this.userRole)
                .level(this.userLevel)
                .team(this.team)
                .build();
    }

}
