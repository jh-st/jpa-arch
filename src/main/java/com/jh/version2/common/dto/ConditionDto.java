package com.jh.version2.common.dto;

import com.jh.version2.common.dto.variable.Keyword;
import com.jh.version2.common.dto.variable.Sorting;

import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The type Condition dto.
 *
 * @author [오지훈]
 * @implNote 공통 검색 DTO
 * @since 2020. 10. 27. 오후 3:08:53
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConditionDto {

    @ApiParam(value = "Current page", defaultValue = "0", required = true)
    protected Integer page = 0;

    @ApiParam(value = "Data count of page", defaultValue = "20", required = true)
    protected int size = 20;

    @ApiParam(value = "Keyword")
    protected String keyword;

    @ApiParam(value = "Keyword T1ype")
    protected Keyword keywordType;

    @ApiParam(value = "By Line up", defaultValue = "PK", required = true)
    protected Sorting orderBy;

    @ApiParam(value = "Search Start Date", defaultValue = "2020.01.01")
    protected String beginDt;

    @ApiParam(value = "Search End Date", defaultValue = "2020.12.31")
    protected String endDt;

}
