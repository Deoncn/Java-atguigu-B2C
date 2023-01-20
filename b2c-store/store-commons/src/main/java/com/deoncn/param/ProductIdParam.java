package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:ProductIdParam
 * Package: IntelliJ IDEA
 * Description: 商品id 参数接收
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 9:35
 * @Version: v1.0
 */
@Data
public class ProductIdParam {
    @NotNull
    private Integer productID;
}
