package com.jh.version2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.user.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private UserTeamDto team;

    @JsonIgnore
    private Long teamId;
    @JsonIgnore
    private String teamName;
    @JsonIgnore
    private Integer teamScore;

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

    public UserDto (final Long userId, final String userName, final Integer userAge
        , final Long teamId, final String teamName, final Integer teamScore
    ) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.team = new UserTeamDto(teamId, teamName, teamScore);
    }

}
