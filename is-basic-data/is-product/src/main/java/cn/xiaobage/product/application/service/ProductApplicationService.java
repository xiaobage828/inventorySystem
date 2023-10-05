package cn.xiaobage.product.application.service;

import cn.xiaobage.product.domain.product.entity.Product;
import cn.xiaobage.product.domain.product.service.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {

    @Autowired
    ProductDomainService productDomainService;


    public Product queryProduct(Long productId){
        return productDomainService.queryProduct(productId);
    }
}
