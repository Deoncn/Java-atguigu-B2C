package com.deoncn.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deoncn.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:ProductMapper
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 20:40
 * @Version: v1.0
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
