package com.deoncn.admin.service.impl;

import com.deoncn.admin.service.UserService;
import com.deoncn.clients.UserClient;
import com.deoncn.param.CartListParam;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.User;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:36
 * @Version: v1.0
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    /**
     * 用户的展示业务 方法
     *
     * @param pageParam
     * @return
     */
    @Cacheable(value = "list.user", key = "#pageParam.currentPage+ '-' + #pageParam.pageSize")
    @Override
    public R userList(PageParam pageParam) {
        log.info("UserServiceImpl.userList 业务开始，参数：{}", pageParam);
        R r = userClient.adminListPage(pageParam);
        log.info("UserServiceImpl.userList 业务结束，结果：{}", r);
        return r;
    }

    /**
     * 删除用户数据
     *
     * @param cartListParam
     * @return
     */
    @CacheEvict(value = "list.user", allEntries = true)
    @Override
    public R userRemove(CartListParam cartListParam) {

        R r = userClient.adminRemove(cartListParam);
        log.info("UserServiceImpl.userRemove 业务结束，结果：{}", r);

        return r;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    @CacheEvict(value = "list.user", allEntries = true)
    public R userUpdate(User user) {

        R r = userClient.adminUpdate(user);
        log.info("UserServiceImpl.userUpdate 业务结束，结果：{}", r);
        return r;
    }


    /**
     * 添加用户信息
     *
     * @param user
     */
    @Override
    @CacheEvict(value = "list.user", allEntries = true)
    public R userSave(User user) {

        R r = userClient.adminSave(user);
        log.info("UserServiceImpl.userSave 业务结束，结果：{}",r);


        return r;
    }
}
