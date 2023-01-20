package com.deoncn.search.controller;

import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.search.service.SearchService;
import com.deoncn.utils.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * ClassName:SearchController
 * Package: IntelliJ IDEA
 * Description: search 模块的 Controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 14:59
 * @Version: v1.0
 */


@RestController
@RequestMapping("search")
public class SearchController {


    @Autowired
    private SearchService searchService;

    @PostMapping("product")
    public R searchProduct(@RequestBody ProductSearchParam productSearchParam) throws JsonProcessingException {


        return searchService.search(productSearchParam);
    }


    /**
     * 同步调用进行商品插入！ 覆盖更新
     * */
    @PostMapping("save")
    public R saveProduct(@RequestBody Product product) throws IOException {


        return searchService.save(product);
    }


    @PostMapping("remove")
    public R removeProduct(@RequestBody Integer productId) throws IOException {


        return searchService.remove(productId);
    }


}
