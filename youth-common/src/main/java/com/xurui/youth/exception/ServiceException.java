package com.xurui.youth.exception;

/**
 * <p>
 * 自定义服务异常
 *
 * @author XuRui
 * @date 2018/9/30.
 */
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = 6053143503077662896L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
