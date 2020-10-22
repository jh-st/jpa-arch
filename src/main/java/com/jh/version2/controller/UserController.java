package com.jh.version2.controller;

import com.jh.version2.entity.User;
import com.jh.version2.response.SingleResult;
import com.jh.version2.service.ResponseService;
import com.jh.version2.service.team.TeamService;
import com.jh.version2.service.user.UserService;
import com.jh.version2.service.user.dto.UserConditionDto;
import com.jh.version2.service.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final ResponseService responseService;

    private final UserService userService;

    private final TeamService teamService;

    @GetMapping(value = "/api/v1/user/{id}", name = "유저 단건 조회 V1")
    public UserDto getUserV1(@PathVariable Long id) {
        return userService.findByUserId(id);
    }

    @GetMapping(value = "/api/v2/user/{id}", name = "유저 단건 조회 V2")
    public SingleResult<UserDto> getUserV2(@PathVariable Long id) {
        log.info("UserController.getUserV2");
        return responseService.getResult(userService.findByUserId(id));
    }

    @GetMapping(value = "/api/v1/users", name = "유저 다건 조회 V1")
    public List<User> getUsersV1() {
        return userService.findAll();
    }

    @GetMapping(value = "/api/v2/users", name = "유저 다건 조회 V2")
    public SingleResult<List<UserDto>> getUsersV2() {
        return responseService.getResult(userService.findUsers());
    }

    @GetMapping(value = "/api/v3/users", name = "유저 다건 조회 V3")
    public SingleResult<Page<UserDto>> getUsersV3(final UserConditionDto conditionDto) {
        return responseService.getResult(userService.findPages(conditionDto));
    }
}
