package cn.xiaobage.product.domain.product.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 产品信息表
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@Data
public class Product {

    private Long id;

    private Boolean saleStatus;

    private String imgUrl;

    private String proNo;

    private Brand brand;

    private Category category;

    private String productName;

    private BigDecimal costPrice;

    private BigDecimal wholesalePrice;

    private BigDecimal retailPrice;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
