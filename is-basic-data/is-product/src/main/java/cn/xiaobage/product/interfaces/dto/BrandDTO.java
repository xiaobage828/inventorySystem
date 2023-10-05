package cn.xiaobage.product.interfaces.dto;

import lombok.Data;

@Data
public class BrandDTO {

    private Long id;

    private String brandCnName;

    private String brandEnName;

    private String logoUrl;

    private String brandStory;
}
