package cn.xiaobage.product.interfaces.dto;

import lombok.Data;

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

    private Date createTime;

    private Date updateTime;
}
