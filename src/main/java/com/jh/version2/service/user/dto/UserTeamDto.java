package com.jh.version2.service.user.dto;

import com.jh.version2.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserTeamDto {

    private Long teamId;
    private String teamName;
    private Integer teamScore;

    @Builder
    public UserTeamDto(final Team team) {
        this.teamId = team.getId();
        this.teamName = team.getName();
        this.teamScore = team.getScore();
    }

    public static UserTeamDto of (Team team) {
        return UserTeamDto.builder()
                .team(team)
                .build();
    }


}
