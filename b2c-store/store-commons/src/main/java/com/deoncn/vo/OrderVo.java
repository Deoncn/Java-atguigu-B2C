package com.deoncn.vo;

import com.deoncn.pojo.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ClassName:OrderVo
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 13:03
 * @Version: v1.0
 */
//查询订单需要返回结果
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderVo extends Order {

 @JsonProperty("product_name")
 private String productName;
 @JsonProperty("product_picture")
 private String productPicture;

}