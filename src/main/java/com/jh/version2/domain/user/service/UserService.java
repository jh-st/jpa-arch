package com.jh.version2.domain.user.service;

import com.jh.version2.domain.team.entity.Team;
import com.jh.version2.domain.user.dto.UserApplyDto;
import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import com.jh.version2.domain.user.entity.User;
import com.jh.version2.domain.user.repository.UserRepository;
import com.jh.version2.domain.user.util.UserDtoUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getById(final Long id) {
        log.info("UserService.getById");
        return userRepository.findById(id);
    }

    public User findById(final Long id) {
        log.info("UserService.findById");
        return this.getById(id).orElseThrow(RuntimeException::new);
    }

    public List<User> findAll() {
        log.info("UserService.findAll");
        return userRepository.findAll();
    }

    public List<UserDto> findUsers() {
        log.info("UserService.findUsers");
        return userRepository.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public Page<UserDto> findPages(final UserConditionDto conditionDto) {
        log.info("UserService.findPages");
        return userRepository.findPages(conditionDto);
    }

    public UserDto findByUserId(final Long id) {
        log.info("UserService.findByUserId");
        return this.getById(id)
                .map(UserDto::new)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public UserDto save(final User user) {
        log.info("UserService.save");
        userRepository.save(user);
        return UserDtoUtil.of(user);
    }

    @Transactional
    public UserDto apply(final User user, final UserApplyDto applyDto, final Team team) {
        log.info("UserService.apply");
        return UserDtoUtil.of(user.update(applyDto, team));
    }

    @Transactional
    public UserDto delete(final User user) {
        log.info("UserService.delete");
        return UserDtoUtil.of((User) user.delete());
    }

}
