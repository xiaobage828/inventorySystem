package cn.xiaobage.config.enums;

import cn.xiaobage.config.vo.FailInfo;
import lombok.Getter;

/**
 * @author xiaobage
 * @package cn.xiaobage.config
 * @createTime 2023/10/01 - 21:58
 * @description
 */
@Getter
public enum IsExceptionEnum {

    ADD_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    UPDATE_ERROR(FailInfo.DEFAULT_CODE, "保存数据失败！"),

    ;
    private Integer code;

    private String description;

    IsExceptionEnum(Integer code, String description){
        this.code = code;
        this.description = description;
    }

}
