package com.deoncn.clients;

import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:SearchClient
 * Package: IntelliJ IDEA
 * Description: 搜索服务调用客户端
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 15:31
 * @Version: v1.0
 */
@FeignClient("search-service")
public interface SearchClient {

    @PostMapping("/search/product")
    R search(@RequestBody ProductSearchParam productSearchParam);

    @PostMapping("/search/save")
    R saveOrUpdate(@RequestBody Product product);


    @PostMapping("/search/remove")
    R remove(@RequestBody Integer productId);



}
