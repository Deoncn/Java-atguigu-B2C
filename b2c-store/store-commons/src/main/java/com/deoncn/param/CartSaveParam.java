package com.deoncn.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:CartSaveParam
 * Package: IntelliJ IDEA
 * Description: 购物车添加参数接收
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 14:48
 * @Version: v1.0
 */

@Data
public class CartSaveParam {


    @JsonProperty("product_id")
    @NotNull
    private Integer productId;

    @JsonProperty("user_id")
    @NotNull
    private Integer userId;
}
