package com.jh.version2.domain.user.util;

import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.util.List;

@UtilityClass
public class UserDtoUtil {

    public UserDto of (final User user) {
        return UserDto.builder()
                .user(user)
                .build();
    }

    public UserDto target(final UserDto userDto, final List<String> args) {
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
            return userDto;
        }

        return returnUserDto;
    }

    public UserDto withoutTeam(final UserDto userDto) {
        userDto.setTeam(null);
        return userDto;
    }

}
