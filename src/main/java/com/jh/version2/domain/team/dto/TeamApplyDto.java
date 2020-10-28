package com.jh.version2.domain.team.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamApplyDto {

    private String teamName;
    private Integer teamScore;

}
