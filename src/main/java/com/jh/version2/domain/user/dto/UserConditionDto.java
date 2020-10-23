package com.jh.version2.domain.user.dto;

import com.jh.version2.common.dto.ConditionDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserConditionDto extends ConditionDto {

    private Integer userAge;
    private Long teamId;

}
