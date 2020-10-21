package com.jh.version2.dto.variable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sorting implements EnumType {
    PK("By Private Key")
    , RECENT("By Recent Date")
    , CREATE("By Created Date")
    , UPDATE("By Updated Date")
    ;

    private final String text;

    @Override
    public String getId() {
        return this.name();
    }

    @Override
    public String getText() {
        return this.text;
    }
}
