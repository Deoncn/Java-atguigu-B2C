package com.deoncn.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ClassName:Category
 * Package: IntelliJ IDEA
 * Description: 类别实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 19:54
 * @Version: v1.0
 */


@Data
@TableName("category")
public class Category {

    @JsonProperty("category_id")
    @TableId(type = IdType.AUTO)
    private Integer categoryId;
    @JsonProperty("category_name")
    private String categoryName;

}
