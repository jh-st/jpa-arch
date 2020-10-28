package com.jh.version2.function.service;

import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.repository.TeamRepository;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApiUserService {

    private final UserService userService;

    private final TeamRepository teamRepository;

    public Page<UserDto> getPages(final UserConditionDto conditionDto) {
        log.info("ApiUserService.getPages");
        return userService.findPages(conditionDto);
    }

    public Page<UserDto> getPagesByConfigure(
            final UserConditionDto conditionDto, final List<String> args
    ) {
        log.info("ApiUserService.getPagesByConfigure");
        return userService.findPages(conditionDto).map(o -> UserDto.target(o, args));
    }

    public List<UserDto> getUsers() {
        log.info("ApiUserService.getUsers");
        return userService.findUsers();
    }

    public List<UserDto> getUsersByConfigure(final List<String> args) {
        log.info("ApiUserService.getUsersByConfigure");
        return userService.findUsers().stream().map(o -> UserDto.target(o, args)).collect(Collectors.toList());
    }

    public UserDto getUser(final Long id) {
        log.info("ApiUserService.getUser");
        return userService.findByUserId(id);
    }

    @Transactional
    public UserDto postUser(final UserSaveDto saveDto) {
        log.info("UserService.save");
        final Team team = teamRepository.findById(saveDto.getTeamId()).orElseThrow(RuntimeException::new);
        saveDto.setTeam(team);
        return userService.save(saveDto.toEntity());
    }

    /*@Transactional
    public UserDto apply(final Long userId, final UserApplyDto applyDto) {
        log.info("UserService.apply");
        final User user = this.findById(userId);
        final Team team = teamRepository.findById(applyDto.getTeamId()).orElseThrow(RuntimeException::new);
        user.update(applyDto.getUserAge(), team);
        //user.update(applyDto.getUserAge(), team);
        return UserDto.of(user);
    }*/

}
