package com.deoncn.carousel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deoncn.carousel.mapper.CarouselMapper;
import com.deoncn.carousel.service.CarouselService;
import com.deoncn.pojo.Carousel;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:CarouselServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 17:29
 * @Version: v1.0
 */


@Slf4j
@Service
public class CarouselServiceImpl implements CarouselService {


    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 查询优先级最高的六条轮播图数据
     * 按照优先级查询数据库数据
     * 使用 stream 流，进行内存数据切割，保存6条数据！
     *
     * @return
     */
    @Override
    @Cacheable(value = "list.carousel",key = "#root.methodName",cacheManager = "cacheManagerDay")
    public R list() {

        QueryWrapper<Carousel> carouselQueryWrapper = new QueryWrapper<>();
        carouselQueryWrapper.orderByDesc("priority");

        List<Carousel> list = carouselMapper.selectList(carouselQueryWrapper);
        List<Carousel> collect = list.stream().limit(6).collect(Collectors.toList());

        R ok = R.ok(collect);
        log.info("CarouselServiceImpl.list 业务结束，结果：{}", ok);
        return ok;
    }
}
