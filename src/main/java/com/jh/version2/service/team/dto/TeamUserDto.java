package com.jh.version2.service.team.dto;

import com.jh.version2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamUserDto {

    private String userName;
    private Integer userAge;

    @Builder
    public TeamUserDto(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public static TeamUserDto of (User user) {
        return TeamUserDto.builder()
                .userName(user.getName())
                .userAge(user.getAge())
                .build();
    }

    public TeamUserDto(User user) {
        of(user);
    }

}
