package com.deoncn.clients;

import com.deoncn.param.CartListParam;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.User;
import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:UserClient
 * Package: IntelliJ IDEA
 * Description: 用户客户端
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:32
 * @Version: v1.0
 */
@FeignClient("user-service")
public interface UserClient {

    @PostMapping("/user/admin/list")
    R adminListPage(@RequestBody PageParam pageParam);

    @PostMapping("/user/admin/remove")
    R adminRemove(@RequestBody CartListParam cartListParam);

    @PostMapping("/user/admin/update")
    R adminUpdate(@RequestBody User user);

    @PostMapping("/user/admin/save")
    R adminSave(@RequestBody User user);

}

