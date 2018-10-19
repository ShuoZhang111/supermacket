package com.shuo.supermacket.member.utils;

import com.shuo.supermacket.member.domain.Result;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

    public static Result success() {
        return success(null);
    }
}
