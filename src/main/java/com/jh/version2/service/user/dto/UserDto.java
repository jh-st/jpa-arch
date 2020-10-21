package com.jh.version2.service.user.dto;

import com.jh.version2.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private UserTeamDto team;

    @Builder
    public UserDto (final User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userAge = user.getAge();
        this.team = new UserTeamDto(user.getTeam());
    }

    public static UserDto of (final User user) {
        return UserDto.builder()
                .user(user)
                .build();
    }

}
