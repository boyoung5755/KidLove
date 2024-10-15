package com.KidLove.comm.exception;

import com.KidLove.comm.constant.EException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException{
	
	private String code;
    private String message;

    public BaseException(EException exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }

}
