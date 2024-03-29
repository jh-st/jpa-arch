package com.jh.version2.domain.user.dto;

import com.jh.version2.domain.team.entity.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

}
