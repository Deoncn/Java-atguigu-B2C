package com.deoncn.clients;

import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:CollectClient
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 17:27
 * @Version: v1.0
 */
@FeignClient("collect-service")

public interface CollectClient {
    @PostMapping("/collect/remove/product")
    R remove(@RequestBody Integer productId);

}
