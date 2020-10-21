package com.jh.version2.service;

import com.jh.version2.response.CommonResult;
import com.jh.version2.response.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseService {

    public <T> SingleResult<T> getResult(final T data) {
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
        final SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        result.setResponse(response);
        result.setAlert(alert);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public CommonResult getSuccess() {
        return CommonResult.builder().response(true).build();
    }

    public CommonResult getFail() {
        return CommonResult.builder().response(false).build();
    }

}
