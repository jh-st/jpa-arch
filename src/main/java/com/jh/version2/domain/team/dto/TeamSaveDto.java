package com.jh.version2.domain.team.dto;

import com.jh.version2.domain.team.entity.Team;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamSaveDto {

    private String teamName;
    private Integer teamScore;
    private Long upperId;

    @Builder
    public TeamSaveDto (
            final String teamName
            , final Integer teamScore
    ) {
        this.teamName = teamName;
        this.teamScore = teamScore;
    }

    // test용 > 데이터등록용
    public TeamSaveDto (
            final String teamName
            , final Integer teamScore
            , final Long upperId
    ) {
        this.teamName = teamName;
        this.teamScore = teamScore;
        this.upperId = upperId;
    }

    public Team toEntity() {
        return Team.builder()
                .name(teamName)
                .score(teamScore)
                .upperId(upperId)
                .build();
    }

}
