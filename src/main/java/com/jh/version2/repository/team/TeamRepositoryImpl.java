package com.jh.version2.repository.team;

import com.jh.version2.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepositoryImpl extends QuerydslRepositorySupport implements TeamRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
