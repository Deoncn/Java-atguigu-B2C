package com.deoncn.user.controller;

import com.deoncn.param.UserCheckParam;
import com.deoncn.param.UserLoginParam;
import com.deoncn.pojo.User;
import com.deoncn.user.service.UserService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:UserController
 * Package: IntelliJ IDEA
 * Description: 用户模块的控制器类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 9:32
 * @Version: v1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice;

    /**
     * 检车账号是否可用的接口
     *
     * @Param userCheckParam 接收检查的账号实体 内部有参数校验注解
     * @Param result 获取校验结果的实体对象
     * @Return 返回封装结果R 对象
     */
    @PostMapping("check")
    public R check(@RequestBody @Validated UserCheckParam userCheckParam, BindingResult result) {

        // 检查是否复合校验规则  符合：false  不符合 true
        boolean b = result.hasErrors();

        if (b) {

            return R.fail("账号为null,不可使用！");
        }

        return userservice.check(userCheckParam);
    }

    @PostMapping("register")
    public R register(@RequestBody @Validated User user, BindingResult result) {

        if(result.hasErrors()){
            // 如果存在异常，证明请求参数不符合注解要求
            return R.fail("参数异常，不可注册！");
        }

        return userservice.register(user);
    }


    @PostMapping("login")
    public R login(@RequestBody @Validated UserLoginParam userLoginParam,BindingResult result){

        if (result.hasErrors()){
            //如果存在异常,证明请求参数不符合注解要求
            return  R.fail("参数异常,不可登录!");
        }

        return userservice.login(userLoginParam);
    }

}
