package com.jh.version2.domain.team.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.jh.version2.common.util.ConditionUtil;
import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.entity.QTeam;
import com.jh.version2.domain.team.entity.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TeamRepositoryImpl extends QuerydslRepositorySupport implements TeamRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private Page<TeamDto> getPage(
            final JPAQuery<TeamDto> query
            , final TeamConditionDto conditionDto) {
        PageRequest pageRequest = ConditionUtil.getPageRequest(conditionDto.getPage(), conditionDto.getSize(),
            conditionDto.getOrderBy().getSort());

        final List<TeamDto> list = Objects.requireNonNull(getQuerydsl())
                .applyPagination(pageRequest, query)
                .fetch();
        return new PageImpl<>(list, pageRequest, query.fetchCount());
    }

    @Override
    public Page<TeamDto> findPages(final TeamConditionDto conditionDto) {
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

    /*@Override
    public Page<TeamDto> findPages(TeamConditionDto conditionDto) {
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
                )
                .offset(conditionDto.getPage())
                .limit(conditionDto.getSize())
                .orderBy(qTeam.id.desc())
                ;

        return new PageImpl<>(query.fetch(), conditionDto.getPageRequest(), query.fetchCount());
    }*/
}
