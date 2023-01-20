package com.deoncn.user.controller;

import com.deoncn.param.CartListParam;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.User;
import com.deoncn.user.service.UserService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserAdminController
 * Package: IntelliJ IDEA
 * Description: 后台管理调用的 位置 controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:27
 * @Version: v1.0
 */


@RestController
@RequestMapping("user")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @PostMapping("admin/list")
    public R listPage(@RequestBody PageParam pageParam) {

        return userService.listPage(pageParam);
    }

    @PostMapping("admin/remove")
    public R remove(@RequestBody CartListParam cartListParam) {
        return userService.remove(cartListParam.getUserId());
    }

    @PostMapping("admin/update")
    public R update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("admin/save")
    public R save(@RequestBody User user) {
        return userService.save(user);
    }




}
