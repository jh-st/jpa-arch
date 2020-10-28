package com.jh.version2.function.controller;

import com.jh.version2.common.response.SingleResult;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.function.service.ApiUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jh.version2.common.util.ResponseUtil.getResult;

@Slf4j
@Api(tags = "User", description = "유저")
@RequestMapping(value = "/api/v1/user", name = "유저")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final ApiUserService userService;

    @ApiOperation(value = "유저 다건 조회 paging v1.0")
    @GetMapping(value = "pages", name = "유저 다건 조회 paging v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<UserDto>> getPages(final UserConditionDto conditionDto) {
        log.info("UserController.getPages");
        return getResult(userService.getPages(conditionDto));
    }

    @ApiOperation(value = "유저 다건 조회 paging v1.0 - 특정 필드 조회")
    @GetMapping(value = "pages/configure", name = "유저 다건 조회 v1.0 paging - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<UserDto>> getPagesByConfigure(
            final UserConditionDto conditionDto, @RequestParam final List<String> args) {
        log.info("UserController.getPagesByConfigure");
        return getResult(userService.getPagesByConfigure(conditionDto, args));
    }

    @ApiOperation(value = "유저 다건 조회 list v1.0")
    @GetMapping(name = "유저 다건 조회 v1.0 list"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<UserDto>> getUsers() {
        log.info("UserController.getUsers");
        return getResult(userService.getUsers());
    }

    @ApiOperation(value = "유저 다건 조회 list v1.0 - 특정 필드 조회")
    @GetMapping(value = "configure/user", name = "유저 다건 조회 v1.0 list - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<UserDto>> getUsersByConfigure(@RequestParam final List<String> args) {
        log.info("UserController.getUsersByConfigure");
        return getResult(userService.getUsersByConfigure(args));
    }

    @ApiOperation(value = "유저 단건 조회 v1.0")
    @GetMapping(value = "/{id}", name = "유저 단건 조회 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> getUser(
            @ApiParam(value = "유저 ID", required = true) @PathVariable final Long id) {
        log.info("UserController.getUser");
        return getResult(userService.getUser(id));
    }

    @ApiOperation(value = "유저 단건 등록 v1.0")
    @PostMapping(name = "유저 단건 등록 v1.0"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> postUser(@RequestBody final UserSaveDto userSaveDto) {
        log.info("UserController.postUser");
        return getResult(userService.postUser(userSaveDto));
    }

}
