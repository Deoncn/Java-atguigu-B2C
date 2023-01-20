package com.deoncn.order.service;

import com.deoncn.param.OrderParam;
import com.deoncn.param.PageParam;
import com.deoncn.utils.R;

/**
 * ClassName:OrderService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 12:06
 * @Version: v1.0
 */
public interface OrderService {

    /**
     * 进行订单数据保存业务
     * @param orderParam
     * @return
     */
    R save(OrderParam orderParam);

    /**
     * 分组查询 订单数据
     * @param userId
     * @return
     * */
    R list(Integer userId);


    /**
     * 检查 订单中是否有商品引用
     * @param productId
     * @return
     *
     * */
    R check(Integer productId);

    /**
     * 后台管理 查询订单数据
     *
     * */
    R adminList(PageParam pageParam);
}
