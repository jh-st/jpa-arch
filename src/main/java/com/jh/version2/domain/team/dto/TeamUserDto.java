package com.jh.version2.domain.team.dto;

import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamUserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private Role userRole;

    @Builder
    public TeamUserDto(final User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userAge = user.getAge();
        this.userRole = user.getRole();
    }

}
