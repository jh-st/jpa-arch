package com.jh.version2.domain.team.service;

import com.jh.version2.domain.team.dto.TeamApplyDto;
import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Optional<Team> getById(final Long id) {
        log.info("TeamService.getById");
        return teamRepository.findById(id);
    }
    
    public Team findById(final Long id) {
        log.info("TeamService.findById");
        return teamRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Team> findAll() {
        log.info("TeamService.findAll");
        return teamRepository.findAll();
    }

    public List<TeamDto> findTeams() {
        log.info("TeamService.findTeams");
        return teamRepository.findAll()
                .stream()
                .map(TeamDto::new)
                .collect(Collectors.toList());
    }

    public Page<TeamDto> findPages(final TeamConditionDto conditionDto) {
        log.info("TeamService.findPages");
        return teamRepository.findPages(conditionDto);
    }

    public TeamDto findByTeamId(final Long id) {
        log.info("TeamService.findByTeamId");
        return teamRepository.findById(id)
                .map(TeamDto::new)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public TeamDto save(final Team team) {
        log.info("TeamService.save");
        teamRepository.save(team);
        return TeamDto.of(team);
    }

    @Transactional
    public TeamDto apply(final Team team, final TeamApplyDto applyDto) {
        log.info("TeamService.apply");
        return TeamDto.of(team.update(applyDto));
    }

    @Transactional
    public TeamDto delete(final Team team) {
        log.info("TeamService.delete");
        return TeamDto.of((Team) team.delete());
    }
}
