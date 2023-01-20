package com.deoncn.param;

import lombok.Data;

/**
 * ClassName:ProductSearchParam
 * Package: IntelliJ IDEA
 * Description: 搜索关键字和分页参数集合
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 14:56
 * @Version: v1.0
 */


@Data
public class ProductSearchParam extends PageParam{
    private String search;
}


