package com.jh.version2.common.util;

import com.jh.version2.common.response.CommonResult;
import com.jh.version2.common.response.SingleResult;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ResponseUtil {

    public <T> SingleResult<T> getResult(final T data) {
        log.info("ResponseService.getResult");
        final SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        return result;
    }

    public <T> SingleResult<T> getResult(
            final T data
            , final boolean alert
            , final String code
            , final String message
    ) {
        log.info("ResponseService.getResult");
        final SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        result.setAlert(alert);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public <T> SingleResult<T> getResult(
            final T data
            , final boolean response
            , final boolean alert
            , final String code
            , final String message
    ) {
        log.info("ResponseService.getResult");
        final SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        result.setResponse(response);
        result.setAlert(alert);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public CommonResult getSuccess() {
        log.info("ResponseService.getSuccess");
        return CommonResult.builder().response(true).build();
    }

    public CommonResult getFail() {
        log.info("ResponseService.getFail");
        return CommonResult.builder().response(false).build();
    }

}
