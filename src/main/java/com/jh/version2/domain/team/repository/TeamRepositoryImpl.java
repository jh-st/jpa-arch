package com.jh.version2.domain.team.repository;

import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.entity.QTeam;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.user.entity.QUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TeamRepositoryImpl extends QuerydslRepositorySupport implements TeamRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private Page<TeamDto> getPage(
            final JPAQuery<TeamDto> query
            , final TeamConditionDto conditionDto
            ) {
        final List<TeamDto> list = Objects.requireNonNull(getQuerydsl())
                .applyPagination(conditionDto.getPageRequest(), query)
                .fetch();
        return new PageImpl<>(list, conditionDto.getPageRequest(), query.fetchCount());
    }

    @Override
    public Page<TeamDto> findPages(final TeamConditionDto conditionDto) {
        final QUser qUser = QUser.user;
        final QTeam qTeam = QTeam.team;
        final JPAQuery<TeamDto> query = jpaQueryFactory
                .select(Projections.constructor(
                        TeamDto.class
                        , qTeam
                ))
                .from(qTeam)
                .where(
                        TeamPredicateHelper.basicCondition()
                        , TeamPredicateHelper.compareKeyword(conditionDto)
                );

        return getPage(query, conditionDto);
    }

}
