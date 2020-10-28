package com.jh.version2.common.dto.variable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Level implements EnumType {
    HIGH("상")
    ,MEDIUM("중")
    ,LOW("하");

    private final String text;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }
}
