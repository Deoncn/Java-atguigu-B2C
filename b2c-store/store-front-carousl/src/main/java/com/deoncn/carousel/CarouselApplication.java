package com.deoncn.carousel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ClassName:CarouselApplication
 * Package: IntelliJ IDEA
 * Description: 轮播图的启动类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 17:16
 * @Version: v1.0
 */

@MapperScan(basePackages = "com.deoncn.carousel.mapper")
@SpringBootApplication
@EnableCaching
public class CarouselApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarouselApplication.class, args);
    }
}
