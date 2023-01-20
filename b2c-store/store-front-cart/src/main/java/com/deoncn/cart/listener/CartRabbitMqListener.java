package com.deoncn.cart.listener;

import com.deoncn.cart.service.CartService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:CartRabbitMqListener
 * Package: IntelliJ IDEA
 * Description: 监听 mq 消息队列
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 12:27
 * @Version: v1.0
 */

@Component
public class CartRabbitMqListener {

    @Autowired
    private CartService cartService;


    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(name ="clear.queue"),
                    exchange = @Exchange(value = "topic.ex"),
                    key = "clear.cart"
            )
    )
    public void clear(List<Integer> cartIds) {
        cartService.clearIds(cartIds);
    }

}
