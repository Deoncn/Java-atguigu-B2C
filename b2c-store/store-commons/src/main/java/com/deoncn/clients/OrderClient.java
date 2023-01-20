package com.deoncn.clients;

import com.deoncn.param.PageParam;
import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:OrderClient
 * Package: IntelliJ IDEA
 * Description: 订单对应的 feign 客户端
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 17:14
 * @Version: v1.0
 */

@FeignClient("order-service")
public interface OrderClient {


    @PostMapping("/order/remove/check")
    R check(@RequestBody Integer productId);

    @PostMapping("/order/admin/list")
    R list(@RequestBody PageParam pageParam);


}
