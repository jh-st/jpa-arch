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

    public List<TeamDto> convert(final List<Team> teams) {
        return ObjectUtils.isEmpty(teams) ? null :
                teams
                .stream()
                .filter(TeamDtoUtil::condition)
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    public Boolean condition(Team team) {
        return team.getUseYn().equals(YesOrNo.Y)
                && team.getDeleteYn().equals(YesOrNo.N);
    }

    public TeamDto of (final Team team) {
        return TeamDto.builder()
                .team(team)
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
