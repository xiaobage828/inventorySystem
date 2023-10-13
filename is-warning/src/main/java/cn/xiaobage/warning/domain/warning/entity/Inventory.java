package cn.xiaobage.warning.domain.warning.entity;


import lombok.Data;

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

    private Date createTime;

    private Date updateTime;
}
