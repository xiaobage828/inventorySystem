package cn.xiaobage.config.exception;


import cn.xiaobage.config.vo.FailInfo;

public class IsCodeException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public IsCodeException() {
    }

    public IsCodeException(Integer code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public IsCodeException(String message, Object... args) {
        super(String.format(message, args));
        this.code = FailInfo.DEFAULT_CODE;
    }

    public IsCodeException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
        this.code = FailInfo.DEFAULT_CODE;
    }

    public IsCodeException(Throwable cause) {
        super(cause);
        this.code = FailInfo.DEFAULT_CODE;
    }

}
