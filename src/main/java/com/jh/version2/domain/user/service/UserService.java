package com.jh.version2.domain.user.service;

import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.team.repository.TeamRepository;
import com.jh.version2.domain.user.dto.UserApplyDto;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.dto.UserSaveDto;
import com.jh.version2.domain.user.entity.User;
import com.jh.version2.domain.user.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    public User findById(final Long userId) {
        log.info("UserService.findById");
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public List<User> findAll() {
        log.info("UserService.findAll");
        return userRepository.findAll();
    }

    public List<UserDto> findUsers() {
        log.info("UserService.findUsers");
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public Page<UserDto> findPages(final UserConditionDto conditionDto) {
        log.info("UserService.findPages");
        return userRepository.findPages(conditionDto);
    }

    public UserDto findByUserId(final Long userId) {
        log.info("UserService.findByUserId");
        System.out.println("2======================================================");
        return userRepository.findById(userId).map(UserDto::new).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public UserDto save(final UserSaveDto saveDto) {
        log.info("UserService.save");
        final Team team = teamRepository.findById(saveDto.getTeamId()).orElseThrow(RuntimeException::new);
        final User user = userRepository.save(
                User.builder()
                        .name(saveDto.getUserName())
                        .age(saveDto.getUserAge())
                        .team(team)
                        .build());
        return UserDto.of(user);
    }

    @Transactional
    public UserDto apply(final Long userId, final UserApplyDto applyDto) {
        log.info("UserService.apply");
        final User user = this.findById(userId);
        final Team team = teamRepository.findById(applyDto.getTeamId()).orElseThrow(RuntimeException::new);
        user.update(applyDto.getUserAge(), team);
        return UserDto.of(user);
    }

}
