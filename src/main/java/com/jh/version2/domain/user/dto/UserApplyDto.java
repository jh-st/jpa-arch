package com.jh.version2.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserApplyDto {

    private Integer userAge;
    private Long teamId;

}
