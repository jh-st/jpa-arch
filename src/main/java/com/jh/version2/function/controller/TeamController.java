package com.jh.version2.function.controller;

import com.jh.version2.domain.team.service.TeamService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "Team", description = "팀")
@RequestMapping(value = "/api/v1/team", name = "팀")
@RestController
@RequiredArgsConstructor
public class TeamController {
    
    private final TeamService teamService;

    /*@ApiOperation(value = "팀 다건 조회 paging v1.0")
    @GetMapping(value = "pages", name = "팀 다건 조회 paging v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<TeamDto>> getPages(final TeamConditionDto conditionDto) {
        log.info("TeamController.getPages");
        return getResult(teamService.findPages(conditionDto));
    }

    @ApiOperation(value = "팀 다건 조회 paging v1.0 - 특정 필드 조회")
    @GetMapping(value = "pages/configure", name = "팀 다건 조회 v1.0 paging - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<TeamDto>> getPagesByConfigure(final TeamConditionDto conditionDto) {
        log.info("TeamController.getPagesByConfigure");
        return getResult(teamService.findPagesByConfigure(
                conditionDto, Arrays.asList("userName", "userAge")));
    }

    @ApiOperation(value = "팀 다건 조회 list v1.0")
    @GetMapping(name = "팀 다건 조회 v1.0 list"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<TeamDto>> getTeams() {
        log.info("TeamController.getTeams");
        return getResult(teamService.findTeams());
    }

    @ApiOperation(value = "팀 다건 조회 list v1.0 - 특정 필드 조회")
    @GetMapping(value = "configure/user", name = "팀 다건 조회 v1.0 list - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<TeamDto>> getTeamsByConfigure(@RequestParam final List<String> args) {
        log.info("TeamController.getTeamsByConfigure");
        return getResult(teamService.findTeamsByConfigure(args));
    }

    @ApiOperation(value = "팀 단건 조회 v1.0")
    @GetMapping(value = "/{id}", name = "팀 단건 조회 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<TeamDto> getTeam(
            @ApiParam(value = "팀 ID", required = true) @PathVariable final Long id) {
        log.info("TeamController.getTeam");
        return getResult(teamService.findByTeamId(id));
    }*/
    
}
