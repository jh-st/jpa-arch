package com.jh.version2.dto;

import com.jh.version2.dto.variable.Keyword;
import com.jh.version2.dto.variable.Sorting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConditionDto {

    private Integer page = 0;
    private int size = 20;
    private String keyword;
    private Keyword keywordType;
    private Sorting orderBy;
    private String beginDt;
    private String endDt;

    public Sort getSort() {
        return Sort.by(this.orderBy.getId()).descending();
    }
}
