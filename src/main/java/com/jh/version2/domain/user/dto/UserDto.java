package com.jh.version2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.dto.variable.Role;
import com.jh.version2.domain.user.entity.User;
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
public class UserDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private Role userRole;
    private UserTeamDto team;

    @Builder
    public UserDto (final User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userAge = user.getAge();
        this.userRole = user.getRole();
        this.team = new UserTeamDto(user.getTeam());
    }

    public static UserDto of (final User user) {
        return UserDto.builder()
                .user(user)
                .build();
    }

    public static UserDto target(UserDto userDto, List<String> args) {
        final UserDto returnUserDto = new UserDto();

        if(ObjectUtils.isEmpty(args.size())) {
            return userDto;
        }

        try {
            for (Field field : returnUserDto.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                for (String arg : args) {
                    if (arg.equals(field.getName())) {
                        final Field declaredField = returnUserDto.getClass().getDeclaredField(field.getName());
                        declaredField.setAccessible(true);
                        declaredField.set(returnUserDto, field.get(userDto));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return userDto;
        }

        return returnUserDto;
    }

}
