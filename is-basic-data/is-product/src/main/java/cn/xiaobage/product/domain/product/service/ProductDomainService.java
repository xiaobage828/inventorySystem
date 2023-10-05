package cn.xiaobage.product.domain.product.service;

import cn.xiaobage.product.domain.product.entity.Product;
import cn.xiaobage.product.domain.product.repository.facade.BrandRepository;
import cn.xiaobage.product.domain.product.repository.facade.CategoryRepository;
import cn.xiaobage.product.domain.product.repository.facade.ProductRepository;
import cn.xiaobage.product.domain.product.repository.po.BrandPO;
import cn.xiaobage.product.domain.product.repository.po.CategoryPO;
import cn.xiaobage.product.domain.product.repository.po.ProductPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDomainService {

    @Autowired
    BrandRepository brandRepositoryImpl;

    @Autowired
    CategoryRepository categoryRepositoryImpl;

    @Autowired
    ProductRepository productRepositoryImpl;

    @Autowired
    CategoryFactory categoryFactory;

    @Autowired
    BrandFactory brandFactory;

    @Autowired
    ProductFactory productFactory;


    public Product queryProduct(Long productId){
        ProductPO productPO = productRepositoryImpl.queryProduct(productId);
        BrandPO brandPO = brandRepositoryImpl.queryBrand(productPO.getBrandId());
        CategoryPO categoryPO = categoryRepositoryImpl.queryCategory(productPO.getCategoryId());
        return productFactory.createProduct(productPO,brandFactory.createBrand(brandPO),categoryFactory.createCategory(categoryPO));
    }


}
