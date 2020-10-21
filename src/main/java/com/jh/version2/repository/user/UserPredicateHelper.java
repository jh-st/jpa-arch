package com.jh.version2.repository.user;

import com.jh.version2.entity.QUser;
import com.jh.version2.service.user.dto.UserConditionDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

@UtilityClass
public class UserPredicateHelper {

    public Predicate compareKeyword(final UserConditionDto conditionDto) {
        if (!ObjectUtils.isEmpty(conditionDto.getKeywordType())) {
            final BooleanBuilder builder = new BooleanBuilder();
            //TODO[ojh] 2020/10/21 : 개발중
        }

        else {
            final BooleanBuilder builder = new BooleanBuilder();
            builder
                    .or(QUser.user.name.eq(conditionDto.getKeyword()));
        }

        return null;
    }

}
