package cn.xiaobage.inventory.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@ApiModel(value = "InventoryDTO", description = "库存DTO")
@Data
public class InventoryDTO {

    @ApiModelProperty(name = "id", value = "库存id")
    private Long id;

    @ApiModelProperty(name = "warehouseId", value = "仓库id")
    private Long warehouseId;

    @ApiModelProperty(name = "productId", value = "产品id")
    private Long productId;

    @ApiModelProperty(name = "totalQuantity", value = "总库存")
    private Integer totalQuantity;

    @ApiModelProperty(name = "lockQuantity", value = "锁定库存")
    private Integer lockQuantity;

    @ApiModelProperty(name = "damagedQuantity", value = "损坏库存")
    private Integer damagedQuantity;

    @ApiModelProperty(name = "units", value = "单位")
    private String units;

    @ApiModelProperty(name = "createTime",value = "库存创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "库存修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
