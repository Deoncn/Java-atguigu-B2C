package com.deoncn.doc;

import com.deoncn.pojo.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ProductDoc
 * Package: IntelliJ IDEA
 * Description: 用来存储商品搜索数据的实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 14:14
 * @Version: v1.0
 */

@Data
@NoArgsConstructor
public class ProductDoc extends Product {


    /**
     * 商品名称和商品标题和商品描述的综合值
     */
    private String all;

    public ProductDoc(Product product) {
        super(product.getProductId(), product.getProductName(), product.getCategoryId(), product.getProductTitle(), product.getProductIntro(), product.getProductPicture(), product.getProductPrice(), product.getProductSellingPrice(), product.getProductNum(), product.getProductSales());

        this.all = product.getProductName() + product.getProductTitle() + product.getProductIntro();
    }
}
