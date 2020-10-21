package com.jh.version2.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CommonResult {

    private boolean response = true;
    private boolean alert = false;
    private String code = "SUCCESS";
    private String message = "성공";
    //private Integer status = HttpStatus.OK.value();

    @Builder
    public CommonResult (final Boolean response) {
        this.response = response;
        //this.status = response ? HttpStatus.OK.value() : HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.code = response ? "SUCCESS" : "FAIL";
        this.message = response ? "성공" : "싫패";
        this.alert = !response;
    }

}
