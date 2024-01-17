package com.jh.version2.domain.team.util;

import com.jh.version2.common.dto.variable.YesOrNo;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.entity.Team;

import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TeamDtoUtil {

    public List<TeamDto> getChildren(final List<Team> teams) {
        return ObjectUtils.isEmpty(teams) ? null :
                teams.stream()
                    .filter(TeamDtoUtil::condition)
                    .map(team ->
                        TeamDto.builder()
                            .teamId(team.getId())
                            .teamName(team.getName())
                            .teamScore(team.getScore())
                            .users(TeamUserDtoUtil.convert(team.getUsers()))
                            .children(getChildren(team.getChildren()))
                            .build()
                    )
                    .collect(Collectors.toList());
    }

    public TeamDto getParent(final Team team) {
        return team != null && team.getId() != null ?
            TeamDto.builder()
                .teamId(team.getId())
                .teamName(team.getName())
                .teamScore(team.getScore())
                .build() : null;
    }

    public Boolean condition(Team team) {
        return team.getUseYn().equals(YesOrNo.Y)
                && team.getDeleteYn().equals(YesOrNo.N);
    }

    public TeamDto of (final Team team) {
        return TeamDto.builder()
            .teamId(team.getId())
            .teamName(team.getName())
            .teamScore(team.getScore())
            .users(TeamUserDtoUtil.convert(team.getUsers()))
            .children(getChildren(team.getChildren()))
            .parent(getParent(team.getParent()))
            .build();
    }

    public TeamDto target(TeamDto teamDto, List<String> args) {
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
            return teamDto;
        }

        return returnDto;
    }

}
