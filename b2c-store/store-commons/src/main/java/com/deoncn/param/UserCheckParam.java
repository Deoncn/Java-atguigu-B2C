package com.deoncn.param;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * ClassName:UserCheckParam
 * Package: IntelliJ IDEA
 * Description: 接收前端参数的Param
 * TODO ：使用JSR 303 的注解进行参数校验！
 * @Blank 字符串 不能为nul 和空字符串 ""
 * @NotNull 字符串  不能为null
 * @NotEmpty 集合类型 集合长度不能为0
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 9:27
 * @Version: v1.0
 */
@Data
public class UserCheckParam {

    @NotBlank
    private String userName; // 注意：参数名称要等与前端传递的JSON key 的名称！
}
