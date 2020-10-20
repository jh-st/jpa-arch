package com.jh.version2.service.user.dto;

import com.jh.version2.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserTeamDto {

    private String teamName;
    private Integer teamScore;

    @Builder
    public UserTeamDto(String teamName, Integer teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;
    }

    public static UserTeamDto of (Team team) {
        return UserTeamDto.builder()
                .teamName(team.getName())
                .teamScore(team.getScore())
                .build();
    }

    public UserTeamDto (Team team) {
        of(team);
    }

}
