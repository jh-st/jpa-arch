package com.jh.version2.repository.team;

import com.jh.version2.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>, TeamRepositoryCustom {
}
