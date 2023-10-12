package cn.xiaobage.product.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO {

    private Long id;

    private Boolean saleStatus;

    private String imgUrl;

    private String proNo;

    private BrandDTO brand;

    private CategoryDTO category;

    private String productName;

    private BigDecimal costPrice;

    private BigDecimal wholesalePrice;

    private BigDecimal retailPrice;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
