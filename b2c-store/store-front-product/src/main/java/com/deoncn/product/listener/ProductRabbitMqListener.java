package com.deoncn.product.listener;

import com.deoncn.product.service.ProductService;
import com.deoncn.to.OrderToProduct;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:ProductRabbitMqListener
 * Package: IntelliJ IDEA
 * Description: 商品消息队列监听
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 12:42
 * @Version: v1.0
 */

@Component
public class ProductRabbitMqListener {


    @Autowired
    private ProductService productService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name = "sub.queue"),
                    exchange = @Exchange("topic.ex"),
                    key = "sub.number"
            )
    )
    public void subNumber(List<OrderToProduct> orderToProductList) {

            productService.subNumber(orderToProductList);
    }

}
