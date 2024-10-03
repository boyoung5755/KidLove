package com.KidLove.comm.vo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private HttpStatus result;
    private String msg;
    private T data;

    public ResultVO(final HttpStatus statusCode, final String resultMsg) {
        this.result = statusCode;
        this.msg = resultMsg;
        this.data = null;
    }

    public static<T> ResultVO<T> res(final HttpStatus statusCode, final String resultMsg) {
        return res(statusCode, resultMsg, null);
    }

    public static<T> ResultVO<T> res(final HttpStatus statusCode, final String resultMsg, final T t) {
        return ResultVO.<T>builder()
                .data(t)
                .result(statusCode)
                .msg(resultMsg)
                .build();
    }


}
