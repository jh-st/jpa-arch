package com.jh.version2.service.team.dto;

import com.jh.version2.entity.Team;
import com.jh.version2.entity.User;
import com.jh.version2.service.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TeamDto {

    private String teamName;
    private Integer teamScore;
    private List<TeamUserDto> users;

    @Builder
    public TeamDto(String teamName, Integer teamScore, List<User> users) {
        this.teamName = teamName;
        this.teamScore = teamScore;
        this.users = users.stream().map(TeamUserDto::new).collect(Collectors.toList());
    }

    public static TeamDto of (Team team) {
        return TeamDto.builder()
                .teamName(team.getName())
                .teamScore(team.getScore())
                .users(team.getUsers())
                .build();
    }

    public TeamDto (Team team) {
        of(team);
    }

}
