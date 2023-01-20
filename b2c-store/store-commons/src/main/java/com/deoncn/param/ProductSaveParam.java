package com.deoncn.param;

import com.deoncn.pojo.Product;
import lombok.Data;

/**
 * ClassName:ProductSaveParam
 * Package: IntelliJ IDEA
 * Description: 商品数据保存param
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 12:18
 * @Version: v1.0
 */

@Data
public class ProductSaveParam extends Product {

    /**
     * 保存商品详情的图片地址 , 图片之间使用 + 拼接
     * */
    private String pictures;

}
