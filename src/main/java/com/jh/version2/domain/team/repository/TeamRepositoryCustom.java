package com.jh.version2.domain.team.repository;

import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import org.springframework.data.domain.Page;

public interface TeamRepositoryCustom {

    Page<TeamDto> findPages(final TeamConditionDto conditionDto);

}
