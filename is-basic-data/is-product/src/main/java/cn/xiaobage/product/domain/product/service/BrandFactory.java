package cn.xiaobage.product.domain.product.service;

import cn.xiaobage.product.domain.product.entity.Brand;
import cn.xiaobage.product.domain.product.entity.Category;
import cn.xiaobage.product.domain.product.repository.po.BrandPO;
import org.springframework.stereotype.Service;

@Service
public class BrandFactory {

    public Brand createBrand(BrandPO brandPO){
        Brand brand = new Brand();
        brand.setId(brandPO.getId());
        brand.setBrandCnName(brandPO.getBrandCnName());
        brand.setBrandEnName(brandPO.getBrandEnName());
        brand.setLogoUrl(brandPO.getLogoUrl());
        brand.setBrandStory(brandPO.getBrandStory());
        return brand;
    }
}
