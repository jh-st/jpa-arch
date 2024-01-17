package com.jh.version2.function.controller;

import com.jh.version2.common.response.SingleResult;
import com.jh.version2.common.util.ResponseUtil;
import com.jh.version2.common.validate.ValidationGroups;
import com.jh.version2.domain.user.dto.UserApplyDto;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.function.service.ApiUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "User", description = "유저")
@RequestMapping(value = "/api/v1/user", name = "유저")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final ApiUserService userService;

    @ApiOperation(value = "유저 다건 조회 paging v1.0")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공입니다.")
        , @ApiResponse(code = 400, message = "접근이 올바르지 않습니다.")
    })
    @GetMapping(value = "pages", name = "유저 다건 조회 paging v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<UserDto>> getPages(final UserConditionDto conditionDto) {
        log.info("UserController.getPages");
        return ResponseUtil.getResult(userService.getPages(conditionDto));
    }

    @ApiOperation(value = "유저 다건 조회 paging v1.0 - 특정 필드 조회")
    @GetMapping(value = "pages/configure", name = "유저 다건 조회 v1.0 paging - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<Page<UserDto>> getPagesByConfigure(
            final UserConditionDto conditionDto, @RequestParam final List<String> args) {
        log.info("UserController.getPagesByConfigure");
        return ResponseUtil.getResult(userService.getPagesByConfigure(conditionDto, args));
    }

    @ApiOperation(value = "유저 다건 조회 list v1.0")
    @GetMapping(name = "유저 다건 조회 v1.0 list"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<UserDto>> getUsers() {
        log.info("UserController.getUsers");
        return ResponseUtil.getResult(userService.getUsers());
    }

    @ApiOperation(value = "유저 다건 조회 list v1.0 - 특정 필드 조회")
    @GetMapping(value = "configure/user", name = "유저 다건 조회 v1.0 list - 특정 필드 조회"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<UserDto>> getUsersByConfigure(@RequestParam final List<String> args) {
        log.info("UserController.getUsersByConfigure");
        return ResponseUtil.getResult(userService.getUsersByConfigure(args));
    }

    @ApiOperation(value = "유저 단건 조회 v1.0")
    @GetMapping(value = "/{id}", name = "유저 단건 조회 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> getUser(
            @ApiParam(value = "유저 ID", required = true) @PathVariable final Long id) {
        log.info("UserController.getUser");
        return ResponseUtil.getResult(userService.getUser(id));
    }

    @ApiOperation(value = "유저 단건 조회 v1.0 - single")
    @GetMapping(value = "/single/{id}", name = "유저 단건 조회 v1.0 - single"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> getUserSingle(
            @ApiParam(value = "유저 ID", required = true) @PathVariable final Long id) {
        log.info("UserController.getUserSingle");
        return ResponseUtil.getResult(userService.getUserSingle(id));
    }

    @ApiOperation(value = "유저 단건 등록 v1.0")
    @PostMapping(name = "유저 단건 등록 v1.0"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> postUser(@RequestBody final UserSaveDto saveDto) {
        log.info("UserController.postUser");
        return ResponseUtil.getResult(userService.postUser(saveDto));
    }

    @ApiOperation(value = "유저 단건 기본 정보 수정 v1.0")
    @PutMapping(value = "{id}", name = "유저 단건 기본 정보 수정 v1.0"
            , consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> putUser(
            @ApiParam(value = "유저 ID", required = true) @PathVariable final Long id
            , @RequestBody @Validated({ValidationGroups.Group1.class}) final UserApplyDto applyDto) {
        log.info("UserController.putUser");
        return ResponseUtil.getResult(userService.putUser(id, applyDto));
    }

    @ApiOperation(value = "유저 단건 삭제 v1.0")
    @DeleteMapping(value = "{id}", name = "유저 단건 삭제 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<UserDto> deleteUser(
            @ApiParam(value = "유저 ID", required = true) @PathVariable final Long id) {
        log.info("UserController.deleteUser");
        return ResponseUtil.getResult(userService.deleteUser(id));
    }

    @ApiOperation(value = "유저 다건 삭제 v1.0")
    @DeleteMapping(name = "유저 다건 삭제 v1.0"
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public SingleResult<List<UserDto>> deleteUsers(@RequestParam final List<Long> ids) {
        log.info("UserController.deleteUsers");
        return ResponseUtil.getResult(userService.deleteUsers(ids));
    }

}
