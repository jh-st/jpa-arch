package com.jh.version2.function.service;

import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.service.TeamService;
import com.jh.version2.domain.user.dto.UserApplyDto;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.domain.user.entity.User;
import com.jh.version2.domain.user.service.UserService;
import com.jh.version2.domain.user.util.UserDtoUtil;
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
public class ApiUserService {

    private final UserService userService;
    private final TeamService teamService;

    public Page<UserDto> getPages(final UserConditionDto conditionDto) {
        log.info("ApiUserService.getPages");
        return userService.findPages(conditionDto);
    }

    public Page<UserDto> getPagesByConfigure(
            final UserConditionDto conditionDto, final List<String> args
    ) {
        log.info("ApiUserService.getPagesByConfigure");
        return userService.findPages(conditionDto)
                .map(o -> UserDtoUtil.target(o, args));
    }

    public List<UserDto> getUsers() {
        log.info("ApiUserService.getUsers");
        return userService.findUsers();
    }

    public List<UserDto> getUsersByConfigure(final List<String> args) {
        log.info("ApiUserService.getUsersByConfigure");
        return userService.findUsers()
                .stream()
                .map(o -> UserDtoUtil.target(o, args))
                .collect(Collectors.toList());
    }

    public UserDto getUser(final Long id) {
        log.info("ApiUserService.getUser");
        return userService.findByUserId(id);
    }

    public UserDto getUserSingle(Long id) {
        log.info("ApiUserService.getUserSingle");
        return UserDtoUtil.withoutTeam(this.getUser(id));
    }

    public UserDto postUser(final UserSaveDto saveDto) {
        log.info("UserService.save");
        final Team team = teamService.findById(saveDto.getTeamId());
        saveDto.setTeam(team);
        return userService.save(saveDto.toEntity());
    }

    public UserDto putUser(final Long id, final UserApplyDto applyDto) {
        log.info("UserService.apply");
        final Team team = teamService.findById(applyDto.getTeamId());
        final User user = userService.findById(id);
        return userService.apply(user, applyDto, team);
    }

    public UserDto deleteUser(final Long id) {
        log.info("ApiUserService.deleteUser");
        final User user = userService.findById(id);
        return UserDtoUtil.target(
                userService.delete(user)
                , Arrays.asList("userId", "userName"));
    }

    public List<UserDto> deleteUsers(List<Long> ids) {
        log.info("ApiUserService.deleteUsers");
        return ids
                .stream()
                .map(this::deleteUser)
                .collect(Collectors.toList());
    }

}
