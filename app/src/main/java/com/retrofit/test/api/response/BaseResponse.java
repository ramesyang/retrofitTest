package com.retrofit.test.api.response;

import android.widget.TextView;

import com.retrofit.test.api.model.IpInfo;

/**
 * Created by Administrator on 2016/4/22.
 */
public class BaseResponse<T> {
    public int code;
    public String msg;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
