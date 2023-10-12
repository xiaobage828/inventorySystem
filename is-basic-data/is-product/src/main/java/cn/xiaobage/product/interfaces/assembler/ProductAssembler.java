package cn.xiaobage.product.interfaces.assembler;

import cn.xiaobage.product.domain.product.entity.Product;
import cn.xiaobage.product.interfaces.dto.ProductDTO;

public class ProductAssembler {

    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(CategoryAssembler.toDTO(product.getCategory()));
        productDTO.setBrand(BrandAssembler.toDTO(product.getBrand()));
        productDTO.setCostPrice(product.getCostPrice());
        productDTO.setWholesalePrice(product.getWholesalePrice());
        productDTO.setImgUrl(product.getImgUrl());
        productDTO.setProNo(product.getProNo());
        productDTO.setUpdateTime(product.getUpdateTime());
        productDTO.setCreateTime(product.getCreateTime());
        productDTO.setRetailPrice(product.getRetailPrice());
        productDTO.setSaleStatus(product.getSaleStatus());
        return productDTO;
    }
}
