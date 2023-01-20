package com.deoncn.admin.controller;

import com.deoncn.admin.param.AdminUserParam;
import com.deoncn.admin.pojo.AdminUser;
import com.deoncn.admin.service.AdminUserService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName:AdminUserController
 * Package: IntelliJ IDEA
 * Description: 后台管理用户的登录
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 14:36
 * @Version: v1.0
 */

@RestController
public class AdminUserController {


    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/user/login")
    public R login(@Validated AdminUserParam adminUserParam, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return R.fail("核心参数为 null,登录失败!");
        }

        // 验证码校验
        String captcha = (String) session.getAttribute("captcha");
        if (!adminUserParam.getVerCode().equalsIgnoreCase(captcha)) {
            return R.fail("验证码错误!");
        }

        // 校验是否返回空
        AdminUser user = adminUserService.login(adminUserParam);
        if (user == null) {
            return R.fail("登录失败！账号或密码错误！");
        }

        session.setAttribute("userInfo", user);

        return R.ok("登录成功！");
    }

    @GetMapping("/user/logout")
    public R logout(HttpSession session){
        //清空session
        session.invalidate();
        //session.removeAttribute("userInfo");

        return R.ok("退出登录成功!");
    }

}
