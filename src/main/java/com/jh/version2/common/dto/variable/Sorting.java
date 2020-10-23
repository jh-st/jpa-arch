package com.jh.version2.common.dto.variable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@Getter
@RequiredArgsConstructor
public enum Sorting implements EnumType {
    PK("By Private Key", Sort.by("id").descending())
    , RECENT("By Recent Date", Sort.by("id").descending())
    , CREATE("By Created Date", Sort.by("id").ascending())
    , UPDATE("By Updated Date", Sort.by("id").ascending())
    ;

    private final String text;
    private final Sort sort;

    @Override
    public String getId() {
        return this.name();
    }

    @Override
    public String getText() {
        return this.text;
    }
}
