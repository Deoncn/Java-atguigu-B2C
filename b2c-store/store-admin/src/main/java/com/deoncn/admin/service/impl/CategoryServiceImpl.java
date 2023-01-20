package com.deoncn.admin.service.impl;

import com.deoncn.admin.service.CategoryService;
import com.deoncn.clients.CategoryClient;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ClassName:CategoryServiceImpl
 * Package: IntelliJ IDEA
 * Description: 类别业务实现
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 18:46
 * @Version: v1.0
 */

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryClient categoryClient;

    /**
     * 分页查询方法
     *
     * @param pageParam
     * @return
     */
    @Override
    @Cacheable(value = "list.category", key = "#pageParam.currentPage + '-' + #pageParam.pageSize ")
    public R pageList(PageParam pageParam) {

        R r = categoryClient.adminPageList(pageParam);
        log.info("CategoryServiceImpl.pageList 业务结束，结果：{}", r);
        return r;
    }


    /**
     * 分类数据添加
     *
     * @param category
     * @return
     */
    @Override
    @CacheEvict(value = "list.category", allEntries = true)
    public R save(Category category) {
        R r = categoryClient.adminSave(category);
        log.info("CategoryServiceImpl.save 业务结束，结果：{}", r);
        return r;
    }

    /**
     * 根据id 删除类别数据
     *
     * @param categoryId
     * @return
     */
    @Override
    @CacheEvict(value = "list.category", allEntries = true)
    public R remove(Integer categoryId) {

        R r = categoryClient.adminRemove(categoryId);
        log.info("CategoryServiceImpl.remove 业务结束，结果:{}", r);
        return r;
    }

    /**
     * 修改类别信息
     *
     * @param category
     * @return
     */
    @Override
    @CacheEvict(value = "list.category", allEntries = true)
    public R update(Category category) {

        R r = categoryClient.adminUpdate(category);

        log.info("CategoryServiceImpl.update 业务结束，结果:{}", r);
        return r;


    }
}
