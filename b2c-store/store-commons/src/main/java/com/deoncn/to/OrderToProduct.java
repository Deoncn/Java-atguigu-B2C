package com.deoncn.to;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:OrderToProduct
 * Package: IntelliJ IDEA
 * Description: 订单发送商品服务的实体
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 11:59
 * @Version: v1.0
 */

@Data
public class OrderToProduct implements Serializable {


    public static final Long serialVersionUID = 1L;

    private Integer productId;
    private Integer num;

}
