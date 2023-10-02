package cn.xiaobage.config.exception;


public class IsException extends RuntimeException {
    public IsException() {
    }
    public IsException(String message, Object... args) {
        super(String.format(message, args));
    }

    public IsException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public IsException(Throwable cause) {
        super(cause);
    }

}
