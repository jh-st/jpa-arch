package com.jh.version2.common.dto;

import com.jh.version2.common.dto.variable.Keyword;
import com.jh.version2.common.dto.variable.Sorting;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConditionDto {

    protected Integer page = 0;
    protected int size = 20;
    protected String keyword;
    protected Keyword keywordType;
    protected Sorting orderBy;
    protected String beginDt;
    protected String endDt;

    public Sort getSort() {
        return orderBy.getSort();
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(this.getPage(), this.getSize(), this.getSort());
    }
}
