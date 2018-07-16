package com.demo.exceptions;


import com.demo.enums.ResultEnum;

/**
 * Created by jiarj on 2018-07-13.
 */
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code= resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
