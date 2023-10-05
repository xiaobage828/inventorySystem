package cn.xiaobage.product.domain.product.entity;

import lombok.Data;

@Data
public class Brand {

    private Long id;

    private String brandCnName;

    private String brandEnName;

    private String logoUrl;

    private String brandStory;
}
