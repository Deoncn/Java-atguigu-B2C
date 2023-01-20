package com.deoncn.admin.service;

import com.deoncn.param.CartListParam;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.User;
import com.deoncn.utils.R;

/**
 * ClassName:UserService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 16:35
 * @Version: v1.0
 */
public interface UserService {


    /**
     * 用户的展示业务 方法
     *
     * @param pageParam
     * @return
     */
    R userList(PageParam pageParam);


    /**
     * 删除用户数据
     *
     * @param cartListParam
     * @return
     */
    R userRemove(CartListParam cartListParam);


    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    R userUpdate(User user);

    /**
     * 添加用户信息
     */
    R userSave(User user);
}
