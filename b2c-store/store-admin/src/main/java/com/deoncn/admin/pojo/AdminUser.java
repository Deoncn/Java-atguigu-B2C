package com.deoncn.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:AdminUser
 * Package: IntelliJ IDEA
 * Description: 后台管理 用户的实体类
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 14:33
 * @Version: v1.0
 */
@Data
@TableName("admin_user")
public class AdminUser  implements Serializable {

 @TableId(type = IdType.AUTO)
 private Integer userId;
 private String userName;
 private String userAccount;
 private String userPassword;
 private String userPhone;
 private Date createTime;
 private Integer userRole;

}

