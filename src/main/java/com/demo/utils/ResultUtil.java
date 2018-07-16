package com.meiling.utils;

import com.meiling.entity.Result;

/**
 * Created by jiarj on 2018-07-13.
 */
public class ResultUtil {

    public static Result<Object> success(Object data){
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public static Result<Object> error(String msg) {
        Result<Object> result = new Result<>();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }
    public static Result<Object> errorToken() {
        Result<Object> result = new Result<>();
        result.setCode(-2);
        result.setMsg("无效的token");
        return result;
    }
    public static Result<Object> error(Integer code ,String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
