package com.jh.version2.domain.user.util;

import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.user.dto.UserTeamDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTeamDtoUtil {

    public static UserTeamDto of (final Team team) {
        return UserTeamDto.builder()
                .team(team)
                .build();
    }

}
