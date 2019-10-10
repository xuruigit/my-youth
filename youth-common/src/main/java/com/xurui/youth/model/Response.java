package com.xurui.youth.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 返回值统一包装类
 *
 * @author XuRui
 * @date 2018/4/19
 */
@Data
@ToString
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -1992163406472311884L;
    /** 必填 是否成功标识 */
    private boolean success;

    /** 非必填 返回结果集 */
    private T result;

    /** 失败时必填 业务码/失败码 全局需唯一 */
    private String code;

    /** 失败时必填 业务文案/失败文案提示 */
    private String message;

    public boolean isSuccess() {
        return this.success;
    }

    public static <T> Response<T> ok(T data) {
        Response resp = new Response();
        resp.setResult(data);
        resp.setSuccess(true);
        return resp;
    }

    public static <T> Response<T> ok() {
        return ok((T) null);
    }

    public static <T> Response<T> fail(String code, String message) {
        Response resp = new Response();
        resp.setCode(code);
        resp.setMessage(message);
        resp.setSuccess(false);
        return resp;
    }

    public static <T> Response<T> failOfMessage(String message) {
        Response resp = new Response();
        resp.setMessage(message);
        resp.setSuccess(false);
        return resp;
    }

    public static <T> Response<T> fail(String code) {
        Response resp = new Response();
        resp.setCode(code);
        resp.setSuccess(false);
        return resp;
    }
}
