package com.deoncn.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * ClassName:User
 * Package: IntelliJ IDEA
 * Description: 用户实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 9:20
 * @Version: v1.0
 */

@Data
@TableName("user")
public class User implements Serializable {
    public static final Long SerialVersionUID = 1L;

    @JsonProperty("user_id") // jackson 注解，用于进行属性格式化！
    @TableId(type = IdType.AUTO)
    private Integer userId;

    @Length(min = 6)
    private String userName;

    // 忽略属性 不生成json 不接收json数据 @JsonIgnore
    // @JsonInclude(JsonInclude.Include.NON_NULL) 当这个值部位null的时候生成Json，为null 不生成
    // 不影响结束json

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank
    private String userPhonenumber;
}
