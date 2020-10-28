package com.jh.version2.domain.team.entity;

import com.jh.version2.common.entity.Base;
import com.jh.version2.domain.team.dto.TeamApplyDto;
import com.jh.version2.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class Team extends Base implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer score;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<User> users;

    @Builder
    public Team(final String name, final Integer score) {
        this.name = name;
        this.score = score;
    }

    public Team update(final TeamApplyDto applyDto) {
        this.name = applyDto.getTeamName();
        this.score = applyDto.getTeamScore();
        return this;
    }

}
