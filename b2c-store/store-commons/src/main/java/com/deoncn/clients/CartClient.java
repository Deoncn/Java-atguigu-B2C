package com.deoncn.clients;

import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:CartClient
 * Package: IntelliJ IDEA
 * Description: 购物车调用 feign 客户端
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 17:07
 * @Version: v1.0
 */

@FeignClient("cart-service")
public interface CartClient {


    @PostMapping("/cart/remove/check")
    R check(@RequestBody Integer productId);
}
