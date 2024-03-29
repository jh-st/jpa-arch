package com.jh.version2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.user.entity.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private Role userRole;
    private UserTeamDto team;

    @Builder
    public UserDto (final User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userAge = user.getAge();
        this.userRole = user.getRole();
        this.team = new UserTeamDto(user.getTeam());
    }

}
