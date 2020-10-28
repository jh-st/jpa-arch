package com.jh.version2.function.controller;

import com.jh.version2.common.response.SingleResult;
import com.jh.version2.common.util.ResponseUtil;
import com.jh.version2.common.validate.ValidationGroups;
import com.jh.version2.domain.team.dto.TeamApplyDto;
import com.jh.version2.domain.team.dto.TeamConditionDto;
import com.jh.version2.domain.team.dto.TeamDto;
import com.jh.version2.domain.team.dto.TeamSaveDto;
import com.jh.version2.function.service.ApiTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Api(tags = "Team", description = "팀")
@RequestMapping(value = "/api/v1/team", name = "팀")
@RestController
@RequiredArgsConstructor
public class TeamController {
    
    private final ApiTeamService teamService;

    @ApiOperation(value = "팀 다건 조회 paging v1.0")
    @GetMapping(value = "pages", name = "팀 다건 조회 paging v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<TeamDto>> getPages(final TeamConditionDto conditionDto) {
        log.info("TeamController.getPages");
        return ResponseUtil.getResult(teamService.getPages(conditionDto));
    }

    @ApiOperation(value = "팀 다건 조회 paging v1.0 - 특정 필드 조회")
    @GetMapping(value = "pages/configure", name = "팀 다건 조회 v1.0 paging - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<TeamDto>> getPagesByConfigure(final TeamConditionDto conditionDto) {
        log.info("TeamController.getPagesByConfigure");
        return ResponseUtil.getResult(teamService.getPagesByConfigure(
                conditionDto, Arrays.asList("userName", "userAge")));
    }

    @ApiOperation(value = "팀 다건 조회 list v1.0")
    @GetMapping(name = "팀 다건 조회 v1.0 list"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<TeamDto>> getTeams() {
        log.info("TeamController.getTeams");
        return ResponseUtil.getResult(teamService.getTeams());
    }

    @ApiOperation(value = "팀 다건 조회 list v1.0 - 특정 필드 조회")
    @GetMapping(value = "configure/user", name = "팀 다건 조회 v1.0 list - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<TeamDto>> getTeamsByConfigure(@RequestParam final List<String> args) {
        log.info("TeamController.getTeamsByConfigure");
        return ResponseUtil.getResult(teamService.getTeamsByConfigure(args));
    }

    @ApiOperation(value = "팀 단건 조회 v1.0")
    @GetMapping(value = "/{id}", name = "팀 단건 조회 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<TeamDto> getTeam(
            @ApiParam(value = "팀 ID", required = true) @PathVariable final Long id) {
        log.info("TeamController.getTeam");
        return ResponseUtil.getResult(teamService.getTeam(id));
    }

    @ApiOperation(value = "팀 단건 등록 v1.0")
    @PostMapping(name = "팀 단건 등록 v1.0"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<TeamDto> postTeam(@RequestBody final TeamSaveDto saveDto) {
        log.info("TeamController.postTeam");
        return ResponseUtil.getResult(teamService.postTeam(saveDto));
    }

    @ApiOperation(value = "팀 단건 기본 정보 수정 v1.0")
    @PutMapping(value = "{id}", name = "팀 단건 기본 정보 수정 v1.0"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<TeamDto> putTeam(
            @ApiParam(value = "팀 ID", required = true) @PathVariable final Long id
            , @RequestBody @Validated({ValidationGroups.Group1.class}) final TeamApplyDto applyDto) {
        log.info("TeamController.putTeam");
        return ResponseUtil.getResult(teamService.putTeam(id, applyDto));
    }

    @ApiOperation(value = "팀 단건 삭제 v1.0")
    @DeleteMapping(value = "{id}", name = "팀 단건 삭제 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<TeamDto> deleteTeam(
            @ApiParam(value = "팀 ID", required = true) @PathVariable final Long id) {
        log.info("TeamController.deleteTeam");
        return ResponseUtil.getResult(teamService.deleteTeam(id));
    }

    @ApiOperation(value = "팀 다건 삭제 v1.0")
    @DeleteMapping(name = "팀 다건 삭제 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<TeamDto>> deleteTeams(@RequestParam final List<Long> ids) {
        log.info("TeamController.deleteTeams");
        return ResponseUtil.getResult(teamService.deleteTeams(ids));
    }
    
}
