package com.jh.version2.domain.user.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.jh.version2.common.util.ConditionUtil;
import com.jh.version2.domain.team.entity.QTeam;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.entity.QUser;
import com.jh.version2.domain.user.entity.User;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.entityManager = entityManager;
        // this.jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private Page<UserDto> getPage(
            final JPAQuery<UserDto> query
            , final UserConditionDto conditionDto
    ) {
        PageRequest pageRequest = ConditionUtil.getPageRequest(conditionDto.getPage(), conditionDto.getSize(),
            conditionDto.getOrderBy().getSort());

        final List<UserDto> list = Objects.requireNonNull(getQuerydsl())
                .applyPagination(pageRequest, query)
                .fetch();
        return new PageImpl<>(list, pageRequest, query.fetchCount());
    }

    @Override
    public Page<UserDto> findPages(final UserConditionDto conditionDto) {
        final QUser qUser = QUser.user;
        final QTeam qTeam = QTeam.team;
        final JPAQuery<UserDto> query = jpaQueryFactory
                .select(Projections.constructor(
                        UserDto.class
                        , qUser
                ))
                .from(qUser)
                .innerJoin(qUser.team, qTeam)
                .where(
                        UserPredicateHelper.basicCondition()
                        , UserPredicateHelper.compareKeyword(conditionDto)
                );

        return getPage(query, conditionDto);
    }

}
