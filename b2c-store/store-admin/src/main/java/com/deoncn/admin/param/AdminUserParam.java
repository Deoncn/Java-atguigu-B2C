package com.deoncn.admin.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * ClassName:AdminUserParam
 * Package: IntelliJ IDEA
 * Description: 接收 登录信息的 Param
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 14:34
 * @Version: v1.0
 */
@Data
public class AdminUserParam {

 @Length(min = 6)
 private String userAccount; //账号
 @Length(min = 6)
 private String userPassword; //密码
 @NotBlank
 private String verCode;  //验证码

}
