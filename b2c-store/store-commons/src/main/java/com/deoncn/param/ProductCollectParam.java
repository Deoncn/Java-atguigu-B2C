package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName:ProductCollectParam
 * Package: IntelliJ IDEA
 * Description: 收藏调用商品传递的参数
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:35
 * @Version: v1.0
 */
@Data
public class ProductCollectParam {


    @NotEmpty
    private List<Integer> productIds;
}
