package com.deoncn.user.service;

import com.deoncn.param.PageParam;
import com.deoncn.param.UserCheckParam;
import com.deoncn.param.UserLoginParam;
import com.deoncn.pojo.User;
import com.deoncn.utils.R;

/**
 * ClassName:Userservice
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 10:02
 * @Version: v1.0
 */
public interface UserService {


    /**
     * 检查账号是否可用业务
     * @param userCheckParam 账号参数 已经校验完毕
     * @return 检擦结果 001     004
     * */
    R check(UserCheckParam userCheckParam);


    /**
     * 注册业务
     * @param user 参数已校验，但密码是明文！
     * @return 结果 001   004
     *
     * */
    R register(User user);


    /**
     * 登录业务
     * @param userLoginParam 账号和密码 已经校验 但是密码是铭文！
     * @return 结果 001       004
     *
     * */
    R login(UserLoginParam userLoginParam);

    /**
     *后台管理调用，查询全部用户数据
     * @param pageParam
     * @return
     * */
    R listPage(PageParam pageParam);

    /**
     * 根据用户 id 删除数据
     * @param userId
     * @return
     *
     * */
    R remove(Integer userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     *
     * */
    R update(User user);


    /**
     * 添加用户信息
     * @param user
     * @return
     * */
    R save(User user);
}
