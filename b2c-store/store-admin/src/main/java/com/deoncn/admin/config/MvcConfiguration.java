package com.deoncn.admin.config;

import com.deoncn.admin.inteceptors.LoginProtectInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:MvcConfiguration
 * Package: IntelliJ IDEA
 * Description: springMVc 配置类
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:15
 * @Version: v1.0
 */

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    /**
     * 用户注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截后台管理模块的路径  排除登录和资源路径
        registry.addInterceptor(new LoginProtectInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/index", "/static/**",
                        "/user/login", "/user/logout",
                        "/api/**", "/css/**", "/images/**",
                        "/js/**", "/lib/**", "/captcha"
                );
    }
}
