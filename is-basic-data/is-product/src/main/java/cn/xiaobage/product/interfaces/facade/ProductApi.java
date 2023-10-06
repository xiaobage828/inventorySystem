package cn.xiaobage.product.interfaces.facade;


import cn.xiaobage.common.api.Response;
import cn.xiaobage.product.application.service.ProductApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 产品信息表 前端控制器
 * </p>
 *
 * @author xiaobage
 * @since 2023年10月05日
 */
@RestController
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    ProductApplicationService productApplicationService;

    @GetMapping("/queryProduct")
    public Response queryProduct(@RequestParam("productId") Long productId){
        Response response = Response.ok(productApplicationService.queryProduct(productId));
        return response;
    }

}

