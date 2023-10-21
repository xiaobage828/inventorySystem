package cn.xiaobage.inventory.domain.inventory.entity;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;




@EqualsAndHashCode
@Data
public class Inventory {

    public final static String ID_FIELD_NAME = "id";

    public final static String WAREHOUSE_ID_FIELD_NAME = "warehouseId";

    public final static String PRODUCT_ID_FIELD_NAME = "productId";

    public final static String TOTAL_QUANTITY_FIELD_NAME = "totalQuantity";

    public final static String LOCK_QUANTITY_FIELD_NAME = "lockQuantity";

    public final static String DAMAGED_QUANTITY_FIELD_NAME = "damagedQuantity";

    public final static String UNITS_FIELD_NAME = "units";

    public final static String CREATE_TIME_FIELD_NAME = "createTime";

    public final static String UPDATE_TIME_FIELD_NAME = "updateTime";
    public static  Inventory NULL_INVENTORY = new Inventory();

    static {
        NULL_INVENTORY.setId(-1L);
        NULL_INVENTORY.setWarehouseId(-1L);
        NULL_INVENTORY.setProductId(-1L);
        NULL_INVENTORY.setUnits("");
        NULL_INVENTORY.setTotalQuantity(-1);
        NULL_INVENTORY.setDamagedQuantity(-1);
        NULL_INVENTORY.setLockQuantity(-1);
        NULL_INVENTORY.setCreateTime(DateUtil.parse("1970-01-01 00:00:01"));
        NULL_INVENTORY.setUpdateTime(DateUtil.parse("1970-01-01 00:00:01"));
    }


    private Long id;

    private Long warehouseId;

    private Long productId;

    private Integer totalQuantity;

    private Integer lockQuantity;

    private Integer damagedQuantity;

    private String units;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Inventory create(){
        id = IdUtil.getSnowflakeNextId();
        this.createTime = new Date();
        this.updateTime = createTime;
        return this;
    }


}
