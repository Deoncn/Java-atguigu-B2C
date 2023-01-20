package com.deoncn.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deoncn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:UserMapper
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 10:07
 * @Version: v1.0
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
