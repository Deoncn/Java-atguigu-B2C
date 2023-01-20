package com.deoncn.collect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deoncn.clients.ProductClient;
import com.deoncn.collect.mapper.CollectMapper;
import com.deoncn.collect.service.CollectService;
import com.deoncn.param.ProductCollectParam;
import com.deoncn.pojo.Collect;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:CollectServiceImpl
 * Package: IntelliJ IDEA
 * Description: 收藏实现类
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:14
 * @Version: v1.0
 */
@Service
@Slf4j
public class CollectServiceImpl implements CollectService {


    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private ProductClient productClient;

    /**
     * 收藏添加的方法
     *
     * @param collect
     * @return
     */
    @Override
    public R save(Collect collect) {

        //1.先查询是否存在

        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("user_id", collect.getUserId());
        queryWrapper.eq("product_id", collect.getProductId());

        Long count = collectMapper.selectCount(queryWrapper);

        if (count > 0) {
            return R.fail("收藏已经添加，无需二次添加");
        }

        //2.不存在进行添加
        //补充下时间
        collect.setCollectTime(System.currentTimeMillis());
        int rows = collectMapper.insert(collect);
        log.info("CollectServiceImpl.save业务结束，结果:{}", rows);

        return R.ok("收藏添加成功！");
    }

    /**
     * 根据用户id 查询商品集合信息
     *
     * @param userId
     * @return
     */
    @Override
    public R list(Integer userId) {
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.select("product_id");

        List<Object> idsObject = collectMapper.selectObjs(queryWrapper);

        ProductCollectParam productCollectParam = new ProductCollectParam();

        List<Integer> ids = new ArrayList<>();
        for (Object o : idsObject) {
            ids.add((Integer) o);
        }
        productCollectParam.setProductIds(ids);

        R r = productClient.productIds(productCollectParam);
        log.info("CollectServiceImpl.list 业务结束，结果：{}", r);
        return r;
    }

    /**
     * 根据用户id 和商品 id 删除收藏数据
     *
     * @param collect userId productId
     * @return 001 004
     */
    @Override
    public R remove(Collect collect) {

        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",collect.getUserId());
        queryWrapper.eq("product_id",collect.getProductId());

        int rows = collectMapper.delete(queryWrapper);
        log.info("CollectServiceImpl.remove 业务结束， 结果:{}",rows);


        return R.ok("收藏移除成功！");
    }

    /**
     * 删除，根据商品 id
     *
     * @param productId
     */
    @Override
    public R removeByPid(Integer productId) {
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productId);

        int rows = collectMapper.delete(queryWrapper);

        log.info("CollectServiceImpl.removeByPid 业务结束，结果：{}",rows);

        return R.ok("收藏商品 删除成功！");
    }
}
