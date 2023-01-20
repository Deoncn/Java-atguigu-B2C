package com.deoncn.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deoncn.admin.mapper.AdminUserMapper;
import com.deoncn.admin.param.AdminUserParam;
import com.deoncn.admin.pojo.AdminUser;
import com.deoncn.admin.service.AdminUserService;
import com.deoncn.constants.UserConstants;
import com.deoncn.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:AdminUserServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 14:45
 * @Version: v1.0
 */

@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    private AdminUserMapper adminUserMapper;


    /**
     * 登录业务方法
     *
     * @param adminUserParam
     * @return
     */
    @Override
    public AdminUser login(AdminUserParam adminUserParam) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account",adminUserParam.getUserAccount());
        // 密码相等
        queryWrapper.eq("user_password", MD5Util.encode(adminUserParam.getUserPassword() + UserConstants.USER_SLAT));

        AdminUser user = adminUserMapper.selectOne(queryWrapper);
        log.info("AdminUserServiceImpl.login 业务结束，结果：{}",user);

        return user;
    }
}
