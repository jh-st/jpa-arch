package com.jh.version2.domain.user.dto;

import com.jh.version2.common.dto.ConditionDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserConditionDto extends ConditionDto {

    private Integer userAge;
    private Long teamId;

}
