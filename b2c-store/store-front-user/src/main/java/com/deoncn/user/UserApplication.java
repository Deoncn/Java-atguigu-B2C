package com.deoncn.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:UserApplication
 * Package: IntelliJ IDEA
 * Description: 用户服务的启动类
 *
 * @ Author: Deoncn
 * @ Create: 2023/1/2 - 8:49
 * @ Version: v1.0
 */
@MapperScan(basePackages = "com.deoncn.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
