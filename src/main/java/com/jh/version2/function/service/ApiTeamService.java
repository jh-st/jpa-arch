package com.jh.version2.function.service;

import com.jh.version2.domain.team.dto.TeamApplyDto;
import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.dto.TeamSaveDto;
import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiTeamService {

    private final TeamService teamService;

    public Page<TeamDto> getPages(final TeamConditionDto conditionDto) {
        log.info("ApiTeamService.getPages");
        return teamService.findPages(conditionDto);
    }

    public Page<TeamDto> getPagesByConfigure(
            final TeamConditionDto conditionDto, final List<String> args
    ) {
        log.info("ApiTeamService.getPagesByConfigure");
        return teamService.findPages(conditionDto).map(o -> TeamDto.target(o, args));
    }

    public List<TeamDto> getTeams() {
        log.info("ApiTeamService.getTeams");
        return teamService.findTeams();
    }

    public List<TeamDto> getTeamsByConfigure(final List<String> args) {
        log.info("ApiTeamService.getTeamsByConfigure");
        return teamService.findTeams().stream().map(o -> TeamDto.target(o, args)).collect(Collectors.toList());
    }

    public TeamDto getTeam(final Long id) {
        log.info("ApiTeamService.getTeam");
        return teamService.findByTeamId(id);
    }

    public TeamDto postTeam(final TeamSaveDto saveDto) {
        log.info("ApiTeamService.postTeam");
        return teamService.save(saveDto.toEntity());
    }

    public TeamDto putTeam(final Long id, final TeamApplyDto applyDto) {
        log.info("ApiTeamService.putTeam");
        return teamService.apply(teamService.findById(id), applyDto);
    }

    public TeamDto deleteTeam(final Long id) {
        log.info("ApiTeamService.deleteUser");
        final Team team = teamService.findById(id);
        if (!team.getUsers().isEmpty()) {
            throw new RuntimeException();
        }

        return TeamDto.target(teamService.delete(team), Arrays.asList("teamId", "teamName"));
    }

    public List<TeamDto> deleteTeams(List<Long> ids) {
        log.info("ApiTeamService.deleteUsers");
        return ids.stream().map(this::deleteTeam).collect(Collectors.toList());
    }

}
