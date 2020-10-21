package com.jh.version2.service.user.dto;

import com.jh.version2.dto.ConditionDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserConditionDto extends ConditionDto {

    private Integer userAge;
    private Long teamId;

    public PageRequest getPageRequest() {
        return PageRequest.of(this.getPage(), this.getSize(), this.getSort());
    }

}
