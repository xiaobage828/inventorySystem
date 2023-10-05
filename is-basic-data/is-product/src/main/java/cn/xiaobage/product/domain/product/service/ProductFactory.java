package cn.xiaobage.product.domain.product.service;

import cn.xiaobage.product.domain.product.entity.Brand;
import cn.xiaobage.product.domain.product.entity.Category;
import cn.xiaobage.product.domain.product.entity.Product;
import cn.xiaobage.product.domain.product.repository.po.ProductPO;
import org.springframework.stereotype.Service;

@Service
public class ProductFactory {

    public Product createProduct(ProductPO productPO, Brand brand, Category category){
        Product product = new Product();
        product.setBrand(brand);
        product.setCategory(category);
        product.setProductName(productPO.getProductName());
        product.setDescription(productPO.getDescription());
        product.setCreateTime(productPO.getCreateTime());
        product.setCostPrice(productPO.getCostPrice());
        product.setImgUrl(productPO.getImgUrl());
        product.setProNo(productPO.getProNo());
        product.setWholesalePrice(productPO.getWholesalePrice());
        product.setRetailPrice(productPO.getRetailPrice());
        product.setSaleStatus(productPO.getSaleStatus());
        product.setUpdateTime(productPO.getUpdateTime());
        product.setId(productPO.getId());
        return product;
    }
}
