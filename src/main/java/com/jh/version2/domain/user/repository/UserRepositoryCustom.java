package com.jh.version2.domain.user.repository;

import com.jh.version2.domain.user.dto.UserConditionDto;
import com.jh.version2.domain.user.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserRepositoryCustom {

    Page<UserDto> findPages(final UserConditionDto conditionDto);

}
