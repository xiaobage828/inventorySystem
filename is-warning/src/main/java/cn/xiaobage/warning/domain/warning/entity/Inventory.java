package cn.xiaobage.warning.domain.warning.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


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
}
