package com.deoncn.collect.service;

import com.deoncn.pojo.Collect;
import com.deoncn.utils.R;
import org.springframework.stereotype.Service;

/**
 * ClassName:CollectService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:12
 * @Version: v1.0
 */

public interface CollectService {


    /**
     * 收藏添加的方法
     *
     * @param collect
     * @return
     */
    R save(Collect collect);



    /**
     * 根据用户id 查询商品集合信息
     * @param userId
     * @return
     * */
    R list(Integer userId);

    /**
     *
     * 根据用户id 和商品 id 删除收藏数据
     * @param collect userId productId
     * @return 001 004
     * */
    R remove(Collect collect);


    /**
     * 删除，根据商品 id
     *
     *
     * */
    R removeByPid(Integer productId);
}
