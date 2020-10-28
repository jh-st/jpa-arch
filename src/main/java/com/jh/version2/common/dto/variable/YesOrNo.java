package com.jh.version2.common.dto.variable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum YesOrNo implements EnumType {
    Y("Yes")
    ,N("No");

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
