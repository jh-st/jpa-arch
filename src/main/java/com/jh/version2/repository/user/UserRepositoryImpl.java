package com.jh.version2.repository.user;

import com.jh.version2.entity.QTeam;
import com.jh.version2.entity.QUser;
import com.jh.version2.entity.User;
import com.jh.version2.service.user.dto.UserConditionDto;
import com.jh.version2.service.user.dto.UserDto;
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
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<UserDto> findPages(final UserConditionDto conditionDto) {
        final QUser qUser = QUser.user;
        final QTeam qTeam = QTeam.team;

        final JPAQuery<UserDto> query = jpaQueryFactory
                .select(Projections.bean(
                        UserDto.class
                        , qUser.id.as("userId")
                        , qUser.name.as("userName")
                        , qUser.age.as("userAge")
                        , qTeam.id.as("teamId")
                        , qTeam.name.as("teamName")
                        , qTeam.score.as("teamScore")
                ))
                .from(qUser)
                .innerJoin(qUser.team, qTeam).fetchJoin()
                .where(
                        UserPredicateHelper.compareKeyword(conditionDto)
                );

        final List<UserDto> users = Objects.requireNonNull(getQuerydsl()).applyPagination(conditionDto.getPageRequest(), query).distinct().fetch();
        return new PageImpl<>(users, conditionDto.getPageRequest(), query.fetchCount());
    }
}
