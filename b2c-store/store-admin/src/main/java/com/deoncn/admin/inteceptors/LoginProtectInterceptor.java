package com.deoncn.admin.inteceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:LoginProtectInterceptor
 * Package: IntelliJ IDEA
 * Description: 登陆保护拦截器
 * 进来的，都是要拦截的！
 * 检查session 中是否有数据， userInfo 有放行！ 没有 跳转到登录页面即可！
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:11
 * @Version: v1.0
 */

@Component
public class LoginProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userInfo = request.getSession().getAttribute("userInfo");

        if (userInfo != null) {
            // 放行，他已登录
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
        //false 拦截 | true 放行

    }

}
