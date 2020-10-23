package com.jh.version2.domain.user.dto;

import com.jh.version2.domain.team.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
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

    public UserTeamDto(final Long teamId, final String teamName, final Integer teamScore) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamScore = teamScore;
    }
}
