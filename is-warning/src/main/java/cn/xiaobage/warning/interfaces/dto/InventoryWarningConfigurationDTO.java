package cn.xiaobage.warning.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@ApiModel(value = "InventoryWarningConfigurationDTO", description = "库存预警配置DTO")
@Data
public class InventoryWarningConfigurationDTO {

    @ApiModelProperty(name = "id", value = "库存id")
    private Long inventoryId;

    @ApiModelProperty(name = "minimumInventory", value = "最小库存")
    private Integer minimumInventory;

    @ApiModelProperty(name = "maximumInventory", value = "最大库存")
    private Integer maximumInventory;

    @ApiModelProperty(name = "units", value = "最大库存")
    private String units;

    @ApiModelProperty(name = "warningPerson", value = "预警信息通知人")
    private Integer warningPerson;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
