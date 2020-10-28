package com.jh.version2.domain.team.dto;

import com.jh.version2.domain.team.entity.Team;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamSaveDto {

    private String teamName;
    private Integer teamScore;

    @Builder
    public TeamSaveDto (
            final String teamName
            , final Integer teamScore
    ) {
        this.teamName = teamName;
        this.teamScore = teamScore;
    }

    public Team toEntity() {
        return Team.builder()
                .name(teamName)
                .score(teamScore)
                .build();
    }

}
