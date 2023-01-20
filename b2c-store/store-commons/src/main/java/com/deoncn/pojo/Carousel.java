package com.deoncn.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ClassName:Carousel
 * Package: IntelliJ IDEA
 * Description: 轮播图实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 17:20
 * @Version: v1.0
 */

@Data
@TableName("carousel")
public class Carousel {

    public static final Long serialVersionUID = 1L;

    @TableId(value = "carousel_id", type = IdType.AUTO)
    @JsonProperty("carousel_id")
    private Integer carouselId;

    @TableField("img_path")
    private String imgPath;
    private String describes;

    @TableField("product_id")
    @JsonProperty("product_id")
    private Integer productId;
    private Integer priority;

}
