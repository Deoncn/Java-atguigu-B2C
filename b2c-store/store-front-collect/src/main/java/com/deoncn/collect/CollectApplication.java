package com.deoncn.collect;

import com.deoncn.clients.ProductClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:CollectApplication
 * Package: IntelliJ IDEA
 * Description: 收藏服务启动类
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:09
 * @Version: v1.0
 */
@MapperScan(basePackages = "com.deoncn.collect.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {ProductClient.class})
public class CollectApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectApplication.class, args);
    }
}
