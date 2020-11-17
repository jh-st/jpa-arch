package com.jh.version2.domain.team.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.util.TeamDtoUtil;
import com.jh.version2.domain.team.util.TeamUserDtoUtil;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDto {

    private Long teamId;
    private String teamName;
    private Integer teamScore;
    private List<TeamUserDto> users;
    private List<TeamDto> teams;

    @Builder
    public TeamDto(final Team team) {
        this.teamId = team.getId();
        this.teamName = team.getName();
        this.teamScore = team.getScore();
        this.users = TeamUserDtoUtil.convert(team.getUsers());
        this.teams = TeamDtoUtil.convert(team.getChildren());
    }

}
