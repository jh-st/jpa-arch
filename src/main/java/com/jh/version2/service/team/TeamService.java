package com.jh.version2.service.team;

import com.jh.version2.entity.Team;
import com.jh.version2.repository.team.TeamRepository;
import com.jh.version2.service.team.dto.TeamApplyDto;
import com.jh.version2.service.team.dto.TeamDto;
import com.jh.version2.service.team.dto.TeamSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team findById(final Long id) {
        return teamRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<TeamDto> findAll() {
        return teamRepository.findAll().stream().map(TeamDto::new).collect(Collectors.toList());
    }

    public TeamDto findByTeamId(final Long id) {
        return teamRepository.findById(id).map(TeamDto::new).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public TeamDto save(final TeamSaveDto saveDto) {
        final Team team = teamRepository.save(
                Team.builder()
                        .name(saveDto.getTeamName())
                        .score(saveDto.getTeamScore())
                        .build());
        return TeamDto.of(team);
    }

    @Transactional
    public TeamDto apply(final Long id, final TeamApplyDto applyDto) {
        final Team team = this.findById(id);
        team.update(applyDto.getTeamName(), applyDto.getTeamScore());
        return TeamDto.of(team);
    }

}
