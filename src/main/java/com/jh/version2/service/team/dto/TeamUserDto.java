package com.jh.version2.service.team.dto;

import com.jh.version2.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamUserDto {

    private String userName;
    private Integer userAge;

    @Builder
    public TeamUserDto(final User user) {
        this.userName = user.getName();
        this.userAge = user.getAge();
    }

    public static TeamUserDto of (final User user) {
        return TeamUserDto.builder()
                .user(user)
                .build();
    }

}
