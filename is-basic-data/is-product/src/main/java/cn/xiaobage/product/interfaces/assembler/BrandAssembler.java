package cn.xiaobage.product.interfaces.assembler;

import cn.xiaobage.product.domain.product.entity.Brand;
import cn.xiaobage.product.interfaces.dto.BrandDTO;

public class BrandAssembler {

    public static BrandDTO toDTO(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setLogoUrl(brand.getLogoUrl());
        brandDTO.setBrandCnName(brand.getBrandCnName());
        brandDTO.setBrandEnName(brand.getBrandEnName());
        brandDTO.setBrandStory(brand.getBrandStory());
        return brandDTO;
    }
}
