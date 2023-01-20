package com.deoncn.product.controller;

import com.deoncn.param.ProductSaveParam;
import com.deoncn.pojo.Product;
import com.deoncn.product.service.ProductService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ProductAdminController
 * Package: IntelliJ IDEA
 * Description: 商品用于后台管理数据支持的 controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 0:43
 * @Version: v1.0
 */

@RestController
@RequestMapping("product")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/count")
    public Long adminCount(@RequestBody Integer categoryId) {

        return productService.adminCount(categoryId);
    }


    @PostMapping("/admin/save")
    public R adminSave(@RequestBody ProductSaveParam productSaveParam) {

        return productService.adminSave(productSaveParam);
    }

    @PostMapping("/admin/update")
    public R adminUpdate(@RequestBody Product product) {

        return productService.adminUpdate(product);
    }

    @PostMapping("/admin/remove")
    public R adminRemove(@RequestBody Integer productId) {

        return productService.adminRemove(productId);
    }

}
