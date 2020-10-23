package com.jh.version2.domain.user.repository;

import com.jh.version2.common.dto.variable.Keyword;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.entity.QUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

@UtilityClass
public class UserPredicateHelper {

    public Predicate compareKeyword(final UserConditionDto conditionDto) {
        final BooleanBuilder builder = new BooleanBuilder();
        final Keyword keywordType = conditionDto.getKeywordType();
        final String keyword = conditionDto.getKeyword();

        if (!ObjectUtils.isEmpty(keyword)) {
            if (!ObjectUtils.isEmpty(keywordType)) {
                if (Keyword.NAME.equals(keywordType)) {
                    builder.or(QUser.user.name.contains(keyword));
                }
            }

            else {
                builder.or(QUser.user.name.contains(keyword));
            }
        }

        return builder;
    }

}
