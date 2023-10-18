package cn.xiaobage.config.exception;


public class IsCodeException extends RuntimeException {

    public static final Integer DEFAULT_CODE = 50000;

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
        this.code = DEFAULT_CODE;
    }

    public IsCodeException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
        this.code = DEFAULT_CODE;
    }

    public IsCodeException(Throwable cause) {
        super(cause);
        this.code = DEFAULT_CODE;
    }

}
