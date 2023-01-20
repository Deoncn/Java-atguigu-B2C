package com.deoncn.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:SearchConfiguration
 * Package: IntelliJ IDEA
 * Description: 配置类
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 12:24
 * @Version: v1.0
 */

@Configuration
public class SearchConfiguration {
    /**
     * mq序列化方式，选择json！
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    /**
     * es客户端添加到ioc容器
     *
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client =
                new RestHighLevelClient(
                        RestClient.builder(HttpHost.create("http://192.168.5.171:9200")));

        return client;
    }
}
