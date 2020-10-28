package com.jh.version2.domain.team.repository;

import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.entity.QTeam;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

import static com.jh.version2.common.dto.variable.YesOrNo.N;
import static com.jh.version2.common.dto.variable.YesOrNo.Y;

@UtilityClass
public class TeamPredicateHelper {

    public Predicate basicCondition() {
        final BooleanBuilder builder = new BooleanBuilder();

        builder.and(QTeam.team.useYn.eq(Y))
                .and(QTeam.team.deleteYn.eq(N));

        return builder;
    }

    public Predicate compareKeyword(TeamConditionDto conditionDto) {
        final BooleanBuilder builder = new BooleanBuilder();

        builder.or(QTeam.team.name.contains(conditionDto.getKeyword()));

        return builder;
    }
}
