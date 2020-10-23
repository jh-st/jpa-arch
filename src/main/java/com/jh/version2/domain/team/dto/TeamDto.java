package com.jh.version2.domain.team.dto;

import com.jh.version2.domain.team.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TeamDto {

    private Long teamId;
    private String teamName;
    private Integer teamScore;
    private List<TeamUserDto> users;

    @Builder
    public TeamDto(final Team team) {
        this.teamId = team.getId();
        this.teamName = team.getName();
        this.teamScore = team.getScore();
        this.users = !(ObjectUtils.isEmpty(team.getUsers()))
                ? team.getUsers().stream().map(TeamUserDto::new).collect(Collectors.toList())
                : null;
    }

    public static TeamDto of (final Team team) {
        return TeamDto.builder()
                .team(team)
                .build();
    }

}
