package com.jh.version2.repository.user;

import com.jh.version2.service.user.dto.UserConditionDto;
import com.jh.version2.service.user.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserRepositoryCustom {

    Page<UserDto> findPages(final UserConditionDto conditionDto);

}
