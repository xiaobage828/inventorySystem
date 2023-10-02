package cn.xiaobage.config.util;

import cn.xiaobage.config.exception.IsException;

/**
 * @author xiaobage
 * @package cn.xiaobage.config.util
 * @createTime 2023/10/01 - 21:52
 * @description
 */
public class AssertUtil {

    /**
     * 条件是 true，抛出消息
     * @param expression
     * @param message
     */
    public static void isTrue(Boolean expression, String message) {
        if (expression) {
            throw new IsException(message);
        }
    }

    /**
     * 条件是 false，抛出消息
     * @param expression
     * @param message
     */
    public static void isFalse(Boolean expression, String message) {
        if (!expression) {
            throw new IsException(message);
        }
    }
}
