package com.deoncn.clients;

import com.deoncn.param.ProductCollectParam;
import com.deoncn.param.ProductIdParam;
import com.deoncn.param.ProductSaveParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * ClassName:ProductClient
 * Package: IntelliJ IDEA
 * Description: 商品服务调用客户端
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 12:20
 * @Version: v1.0
 */

@FeignClient(value = "product-service")
public interface ProductClient {

    /**
     * 搜索服务调用，进行全部数据查询用于搜搜数据库同步数据
     */
    @GetMapping("/product/list")
    List<Product> allList();

    @PostMapping("/product/collect/list")
    R productIds(@RequestBody ProductCollectParam productCollectParam);

    @PostMapping("/product/cart/detail")
    Product productDetail(@RequestBody ProductIdParam productIdParam);

    @PostMapping("/product/cart/list")
    List<Product> cartList(@RequestBody ProductCollectParam productCollectParam);

    @PostMapping("/product/admin/count")
    Long adminCount(@RequestBody Integer categoryId);

    @PostMapping("/product/admin/save")
    R adminCount(@RequestBody ProductSaveParam productSaveParam);

    @PostMapping("/product/admin/update")
    R adminUpdate(@RequestBody Product product);

    @PostMapping("/product/admin/remove")
    R adminRemove(@RequestBody Integer productId);

}
