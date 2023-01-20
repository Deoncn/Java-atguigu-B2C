package com.deoncn.admin.controller;

import com.deoncn.admin.service.UserService;
import com.deoncn.param.CartListParam;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.User;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Package: IntelliJ IDEA
 * Description: 用户模块调用的 Controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:33
 * @Version: v1.0
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public R userList(PageParam pageParam) {
        return userService.userList(pageParam);
    }

    @PostMapping("remove")
    public R userRemove(CartListParam cartListParam) {
        return userService.userRemove(cartListParam);
    }


    @PostMapping("update")
    public R update(User user){
        return userService.userUpdate(user);
    }

    @PostMapping("save")
    public R save(User user){
        return userService.userSave(user);
    }

}
