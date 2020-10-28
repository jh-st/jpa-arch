package com.jh.version2.domain.team.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.domain.team.entity.Team;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
        this.users = TeamUserDto.convert(team.getUsers());
    }

    public static TeamDto of (final Team team) {
        return TeamDto.builder()
                .team(team)
                .build();
    }

    public static TeamDto target(TeamDto teamDto, List<String> args) {
        final TeamDto returnDto = new TeamDto();

        if(ObjectUtils.isEmpty(args.size())) {
            return teamDto;
        }

        try {
            for (Field field : returnDto.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                for (String arg : args) {
                    if (arg.equals(field.getName())) {
                        final Field declaredField = returnDto.getClass().getDeclaredField(field.getName());
                        declaredField.setAccessible(true);
                        declaredField.set(returnDto, field.get(teamDto));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return teamDto;
        }

        return returnDto;
    }

}
