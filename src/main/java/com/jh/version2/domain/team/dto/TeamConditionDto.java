package com.jh.version2.domain.team.dto;

import com.jh.version2.common.dto.ConditionDto;
import io.swagger.annotations.ApiParam;
import lombok.*;

/**
 * The type User condition dto.
 *
 * @author [오지훈]
 * @implNote [팀] 검색 DTO
 * @since 2020. 10. 27. 오후 3:09:38
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamConditionDto extends ConditionDto {

    @ApiParam(value = "The ID of the team")
    private Long teamId;

}
