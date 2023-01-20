package com.deoncn.admin.service;

import com.deoncn.admin.param.AdminUserParam;
import com.deoncn.admin.pojo.AdminUser;

/**
 * ClassName:AdminUserService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 14:44
 * @Version: v1.0
 */
public interface AdminUserService {


 /**
  * 登录业务方法
  * @param adminUserParam
  * @return
  * */
 AdminUser login(AdminUserParam adminUserParam);
}
