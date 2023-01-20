package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName:ProductIdsParam
 * Package: IntelliJ IDEA
 * Description: 类别商品展示
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 9:10
 * @Version: v1.0
 */
@Data
public class ProductIdsParam extends PageParam {

    @NotNull
    private List<Integer> categoryID;

}
