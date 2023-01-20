package com.deoncn.param;

import com.deoncn.vo.CartVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:OrderParam
 * Package: IntelliJ IDEA
 * Description: 订单参数接收的对象
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 11:55
 * @Version: v1.0
 */

@Data
public class OrderParam implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonProperty("user_id")
    private Integer userId;

    private List<CartVo> products;
}
