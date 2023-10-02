package cn.xiaobage.config.util;

import java.util.Map;
import java.util.Objects;

/**
 * @author xiaobage
 * @package cn.xiaobage.config.util
 * @createTime 2023/10/02 - 22:45
 * @description
 */
public class SecurityUtil {

    private static ThreadLocal<Map<String, Object>> userThreadLocal = new ThreadLocal<>();

    public static void addConfig(Map<String, Object> user) {
        userThreadLocal.set(user);
    }

    public static void remove() {
        userThreadLocal.remove();
    }

    public static String getUserName() {
        Object username = userThreadLocal.get().get("username");

        return Objects.isNull(username) ? "" : username.toString();
    }

    public static String getName() {
        Object name = userThreadLocal.get().get("name");

        return Objects.isNull(name) ? "" : name.toString();
    }

    public static Long getUserId() {
        Object userId = userThreadLocal.get().get("id");

        return Objects.isNull(userId) ? 0L : Long.parseLong(userId.toString());
    }

    public static String get(String key) {
        Object value = userThreadLocal.get().get(key);

        return Objects.isNull(value) ? "" : value.toString();
    }

}
