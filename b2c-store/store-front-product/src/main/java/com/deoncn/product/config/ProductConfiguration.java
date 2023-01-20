package com.deoncn.product.config;

import com.deoncn.config.CacheConfiguration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:ProductConfiguration
 * Package: IntelliJ IDEA
 * Description: 商品模块的配置类
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 16:22
 * @Version: v1.0
 */
@Configuration
public class ProductConfiguration extends CacheConfiguration {

    /**
     * mq序列化方式，选择json！
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

}
