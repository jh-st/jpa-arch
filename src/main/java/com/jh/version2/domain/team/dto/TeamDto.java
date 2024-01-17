package com.jh.version2.domain.team.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDto {

    private Long teamId;
    private String teamName;
    private Integer teamScore;
    private List<TeamUserDto> users;
    private List<TeamDto> children;
    private TeamDto parent;


    @Builder
    protected TeamDto(final Long teamId, String teamName, Integer teamScore, List<TeamUserDto> users,
        List<TeamDto> children, TeamDto parent) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamScore = teamScore;
        this.users = users;
        this.children = children;
        this.parent = parent;
    }

}
