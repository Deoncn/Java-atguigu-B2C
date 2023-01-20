package com.deoncn.admin;

import com.deoncn.clients.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:AdminApplication
 * Package: IntelliJ IDEA
 * Description: 启动类
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 13:59
 * @Version: v1.0
 */
@SpringBootApplication
@MapperScan("com.deoncn.admin.mapper")
@EnableCaching
@EnableFeignClients(clients = {UserClient.class, CategoryClient.class, SearchClient.class, ProductClient.class, OrderClient.class})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
