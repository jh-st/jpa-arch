package com.jh.version2.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class SingleResult<T> extends CommonResult {

    private T data;

}
