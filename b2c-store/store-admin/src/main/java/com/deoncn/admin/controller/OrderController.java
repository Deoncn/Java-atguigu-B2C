package com.deoncn.admin.controller;

import com.deoncn.admin.service.OrderService;
import com.deoncn.param.PageParam;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:OrderController
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 19:55
 * @Version: v1.0
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public R list(PageParam pageParam){

        return orderService.list(pageParam);
    }
}
