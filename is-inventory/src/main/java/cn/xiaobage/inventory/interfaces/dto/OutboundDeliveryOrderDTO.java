package cn.xiaobage.inventory.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@ApiModel(value = "库存DTO", description = "InventoryDTO")
@Data
public class OutboundDeliveryOrderDTO {


    @ApiModelProperty(name = "id", value = "出库单id")
    private Long id;

    @ApiModelProperty(name = "recordCode", value = "出库单编码")
    private String recordCode;

    @ApiModelProperty(name = "inventoryId", value = "库存id")
    private Long inventoryId;

    @ApiModelProperty(name = "tag", value = "标签")
    private String tag;

    @ApiModelProperty(name = "quantity", value = "产品出库数量")
    private Integer quantity;

    @ApiModelProperty(name = "units", value = "单位")
    private String units;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "trader", value = "交易方")
    private String trader;

    @ApiModelProperty(name = "tradingTime", value = "交易时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tradingTime;

    @ApiModelProperty(name = "timeOfMaking", value = "出库单制作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeOfMaking;

    @ApiModelProperty(name = "maker", value = "出库单制作人")
    private Integer maker;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
