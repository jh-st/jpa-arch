package com.jh.version2.domain.team.entity;

import com.jh.version2.common.entity.Base;
import com.jh.version2.domain.team.dto.TeamApplyDto;
import com.jh.version2.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Team extends Base implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "UPPER_ID")
    @Nullable
    private Long upperId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SCORE")
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPPER_ID", referencedColumnName = "ID", updatable = false, insertable = false)
    private Team parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Team> children;

    //@JsonIgnore
    //@JsonManagedReference
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<User> users;

    @Builder
    public Team(final String name, final Integer score, @Nullable final Long upperId) {
        this.name = name;
        this.score = score;
        this.upperId = upperId;
    }

    public Team update(final TeamApplyDto applyDto) {
        this.name = applyDto.getTeamName();
        this.score = applyDto.getTeamScore();
        return this;
    }

}
