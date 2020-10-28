package com.jh.version2.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jh.version2.common.dto.variable.Role;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSingleDto {

    private Long userId;
    private String userName;
    private Integer userAge;
    private Role userRole;

    public UserSingleDto (final UserDto userDto) {
        this.userId = userDto.getUserId();
        this.userAge = userDto.getUserAge();
        this.userName = userDto.getUserName();
        this.userRole = userDto.getUserRole();
    }

}
