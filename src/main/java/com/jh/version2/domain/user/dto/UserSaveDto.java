package com.jh.version2.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveDto {

    private String userName;
    private Integer userAge;
    private Long teamId;

    public UserSaveDto (
            final String userName
            , final Integer userAge
            , final Long teamId
    ) {
        this.userName = userName;
        this.userAge = userAge;
        this.teamId = teamId;
    }

}
