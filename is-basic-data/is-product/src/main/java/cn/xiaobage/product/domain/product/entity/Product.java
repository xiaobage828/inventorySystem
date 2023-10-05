package cn.xiaobage.product.domain.product.entity;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    private LocalDate createTime;

    private LocalDate updateTime;

}
