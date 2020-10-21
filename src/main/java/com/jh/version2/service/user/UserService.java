package com.jh.version2.service.user;

import com.jh.version2.entity.Team;
import com.jh.version2.entity.User;
import com.jh.version2.repository.team.TeamRepository;
import com.jh.version2.repository.user.UserRepository;
import com.jh.version2.service.user.dto.UserApplyDto;
import com.jh.version2.service.user.dto.UserConditionDto;
import com.jh.version2.service.user.dto.UserDto;
import com.jh.version2.service.user.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    public User findById(final Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDto> findUsers() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public Page<UserDto> findPages(final UserConditionDto conditionDto) {
        return null;
    }

    public UserDto findByUserId(final Long userId) {
        return userRepository.findById(userId).map(UserDto::new).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public UserDto save(final UserSaveDto saveDto) {
        final User user = userRepository.save(
                User.builder()
                        .name(saveDto.getUserName())
                        .age(saveDto.getUserAge())
                        .team(teamRepository.findById(1L).get())
                        .build());
        return UserDto.of(user);
    }

    @Transactional
    public UserDto apply(final Long userId, final UserApplyDto applyDto) {
        final User user = this.findById(userId);
        final Team team = teamRepository.findById(applyDto.getTeamId()).orElseThrow(RuntimeException::new);
        user.update(applyDto.getUserAge(), team);
        return UserDto.of(user);
    }
}
