package com.deoncn.vo;

import com.deoncn.pojo.Cart;
import com.deoncn.pojo.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:CartVo
 * Package: IntelliJ IDEA
 * Description: 购物车添加返回的 vo
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 14:45
 * @Version: v1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class CartVo implements Serializable {

    private Integer id;  //购物车id
    private Integer productID;  //商品id
    private String productName; //商品名称
    private String productImg; //商品显示图片
    private Double price;  //商城价格
    private Integer num;  //商品购买数量
    private Integer maxNum; //商品限购数量
    private Boolean check = false; //是否勾选

    public CartVo(Product product, Cart cart) {
        this.id = cart.getId();
        this.productID = product.getProductId();
        this.productName = product.getProductName();
        this.productImg = product.getProductPicture();
        this.price = product.getProductSellingPrice();
        this.num = cart.getNum();
        this.maxNum = product.getProductNum();
        this.check = false;
    }
}