package com.deoncn.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:Picture
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 9:41
 * @Version: v1.0
 */

@Data
@TableName("product_picture")
public class Picture implements Serializable {

     public static final Long serialVersionUID =1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("product_id")
    @JsonProperty("product_id")
    private Integer productId;

    @TableField("product_picture")
    @JsonProperty("product_picture")
    private String productPicture;


    private String intro;

}
