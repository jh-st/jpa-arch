package com.jh.version2.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class ListResult<T> extends CommonResult {

    private List<T> list;

}
