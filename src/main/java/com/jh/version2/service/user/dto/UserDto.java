package com.jh.version2.service.user.dto;

import com.jh.version2.entity.Team;
import com.jh.version2.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    private String userName;
    private Integer userAge;
    private UserTeamDto team;

    @Builder
    public UserDto (String userName, Integer userAge, Team team) {
        this.userName = userName;
        this.userAge = userAge;
        this.team = new UserTeamDto(team);
    }

    public static UserDto of (User user) {
        return UserDto.builder()
                .userName(user.getName())
                .userAge(user.getAge())
                .team(user.getTeam())
                .build();
    }

    public UserDto (User user) {
        of(user);
    }

}
