package com.deoncn.product.controller;

import com.deoncn.param.ProductCollectParam;
import com.deoncn.product.service.ProductService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ProductCollectController
 * Package: IntelliJ IDEA
 * Description: 商品被收藏调用的 控制器
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:37
 * @Version: v1.0
 */
@RestController
@RequestMapping("product")
public class ProductCollectController {

    @Autowired
    private ProductService productService;

    @PostMapping("collect/list")
    public R productIds(@RequestBody @Validated ProductCollectParam productCollectParam, BindingResult result) {

        if (result.hasErrors()) {
            return R.ok("没有收藏数据！");
        }

        return productService.ids(productCollectParam.getProductIds());
    }
}
