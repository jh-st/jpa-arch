package com.jh.version2.domain.team.util;

import com.jh.version2.common.dto.variable.YesOrNo;
import com.jh.version2.domain.team.dto.TeamUserDto;
import com.jh.version2.domain.user.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TeamUserDtoUtil {

    public static List<TeamUserDto> convert(final List<User> users) {
        return ObjectUtils.isEmpty(users) ? null :
                users
                .stream()
                .filter(TeamUserDtoUtil::condition)
                .map(TeamUserDto::new)
                .collect(Collectors.toList());
    }

    public Boolean condition(final User user) {
        return user.getUseYn().equals(YesOrNo.Y)
                && user.getDeleteYn().equals(YesOrNo.N);
    }

    public static TeamUserDto of(final User user) {
        return TeamUserDto.builder()
                .user(user)
                .build();
    }

}
