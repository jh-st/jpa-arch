package com.jh.version2.domain.team.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamSaveDto {

    private String teamName;
    private Integer teamScore;

    public TeamSaveDto (final String teamName, final Integer teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;
    }

}
