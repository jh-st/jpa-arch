package com.jh.version2.domain.team.dto;

import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamUserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private Role userRole;

    @Builder
    public TeamUserDto(final User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userAge = user.getAge();
        this.userRole = user.getRole();
    }

    public static List<TeamUserDto> convert(final List<User> users) {
        if (ObjectUtils.isEmpty(users)) {
            return null;
        }

        return users.stream().map(TeamUserDto::new).collect(Collectors.toList());
    }

    public static TeamUserDto of (final User user) {
        return TeamUserDto.builder()
                .user(user)
                .build();
    }

}
