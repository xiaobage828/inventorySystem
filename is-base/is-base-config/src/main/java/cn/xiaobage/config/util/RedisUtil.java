package cn.xiaobage.config.util;

import cn.hutool.core.util.RandomUtil;

public class RedisUtil {

    public static Integer getEmptyTimeOut(){
        return 60 + RandomUtil.randomInt(30);
    }
}
