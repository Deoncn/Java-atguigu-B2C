package com.deoncn.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deoncn.pojo.Order;
import com.deoncn.vo.AdminOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:OrderMapper
 * Package: IntelliJ IDEA
 * Description: order 数据库进行接口
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 12:08
 * @Version: v1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询后台管理的数据方法
     * @param offset
     * @param pageSize
     * @return
     * */
    List<AdminOrderVo> selectAdminOrder(@Param("offset") int offset,@Param("pageSize") int pageSize);
}
