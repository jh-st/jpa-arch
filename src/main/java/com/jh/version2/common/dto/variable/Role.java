package com.jh.version2.common.dto.variable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role implements EnumType {
    ROLE_ADMIN("admin")
    ,ROLE_USER("user");

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
