package com.deoncn.cart.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:CartConfiguration
 * Package: IntelliJ IDEA
 * Description: 购物车配置类
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 12:26
 * @Version: v1.0
 */

@Configuration
public class CartConfiguration {

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
