package com.deoncn.product.controller;

import com.deoncn.param.ProductCollectParam;
import com.deoncn.param.ProductIdParam;
import com.deoncn.pojo.Product;
import com.deoncn.product.service.ProductService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ProductCartController
 * Package: IntelliJ IDEA
 * Description: 购物车调用商品服务的 controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 14:38
 * @Version: v1.0
 */

@RestController
@RequestMapping("product")
public class ProductCartController {

    @Autowired
    private ProductService productService;

    @PostMapping("cart/detail")
    public Product cdetail(@RequestBody @Validated ProductIdParam productIdParam, BindingResult result) {

        if (result.hasErrors()) {
            return null;
        }

        R detail = productService.detail(productIdParam.getProductID());

        Product product = (Product) detail.getData();

        return product;

    }

    @PostMapping("cart/list")
    public List<Product> cartList(@RequestBody @Validated ProductCollectParam productCollectParam,BindingResult result){
        if (result.hasErrors()) {
            return new ArrayList<Product>();
        }

        return productService.cartList(productCollectParam.getProductIds());

    }


}
