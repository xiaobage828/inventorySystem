package cn.xiaobage.config.redisson.key;

import lombok.Getter;

@Getter
public enum KeyType {

    /**
     * 该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)
     */
    NONE(0),

    /**
     * SpEL表达式
     * SpEL表达式获取拦截方法参数的属性的值
     */
    EXPRESSION(1),

    /**
     * 分配ID (string）
     * (雪花算法)
     */
    ASSIGN_ID(2),


    /**
     * 分配MongoDB的ObjectId(string）
     */
    ASSIGN_OBJECT_ID(3),

    /**
     * 分配UUID (主键类型为 string)
     * (UUID.replace("-",""))
     */
    ASSIGN_UUID(4);

    private final int key;

    KeyType(int key) {
        this.key = key;
    }
}

