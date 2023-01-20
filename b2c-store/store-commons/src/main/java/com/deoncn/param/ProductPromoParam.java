package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName:ProductPromoParam
 * Package: IntelliJ IDEA
 * Description: 类别热门商品参数接收
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 19:50
 * @Version: v1.0
 */
@Data
public class ProductPromoParam {

    @NotBlank
    private String categoryName;

}
