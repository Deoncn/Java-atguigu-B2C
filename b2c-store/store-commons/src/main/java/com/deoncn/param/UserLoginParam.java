package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName:UserLoginParam
 * Package: IntelliJ IDEA
 * Description: 用户登录参数实体
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 10:59
 * @Version: v1.0
 */
@Data
public class UserLoginParam {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

}
