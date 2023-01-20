package com.deoncn.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deoncn.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:AddressMapper
 * Package: IntelliJ IDEA
 * Description: 地址数据库访问mapper接口
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 14:07
 * @Version: v1.0
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}
