package com.anuouan.tools;

import lombok.Data;

@Data
public class R<T> {

    private Integer code; //状态码

    private String msg; //提示信息

    private T data; //数据

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(ReturnCode.RC200.getCode());
        r.setMsg(ReturnCode.RC200.getMsg());
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(int code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
