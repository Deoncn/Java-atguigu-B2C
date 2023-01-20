package com.deoncn.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:AdminOrderVo
 * Package: IntelliJ IDEA
 * Description: 后台管理订单显示 实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 18:44
 * @Version: v1.0
 */
@Data
public class AdminOrderVo implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("product_num")
    private Integer productNum; //商品种类
    @JsonProperty("order_num")
    private Integer orderNum; //订单中商品数量
    @JsonProperty("order_price")
    private Double orderPrice; //订单金额
    @JsonProperty("order_time")
    private Long orderTime; //订单时间
}
