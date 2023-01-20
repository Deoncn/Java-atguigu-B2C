package com.deoncn.product.controller;

import com.deoncn.pojo.Product;
import com.deoncn.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:ProductSeachController
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 11:58
 * @Version: v1.0
 */

@RestController
@RequestMapping("product")
public class ProductSearchController {


    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public List<Product> allList() {

        return productService.allList();
    }

}
