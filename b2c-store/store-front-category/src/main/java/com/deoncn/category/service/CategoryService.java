package com.deoncn.category.service;

import com.deoncn.param.PageParam;
import com.deoncn.param.ProductHotParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;

/**
 * ClassName:CategoryService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 20:18
 * @Version: v1.0
 */

public interface CategoryService {


    /**
     * 根据类别名称，查询类别对象
     *
     * @param categoryName
     * @return
     */
    R byName(String categoryName);

    /**
     * 根据传入的热门类别名称集合 返回类别对应 的id 集合
     * @param productHotParam
     * @return
     * */
    R hotsCategory(ProductHotParam productHotParam);


    /**
     * 查询类别数据，进行返回！
     * @return r 类别数据集合
     *
     * */
    R list();

    /**
     * 分页查询
     * @param pageParam
     * @return
     * */
    R listPage(PageParam pageParam);


    /**
     * 添加类别信息
     * @param category
     * @return
     * */
    R adminSave(Category category);

    /**
     * 删除数据
     * @param categoryId
     * @return
     * */
    R adminRemove(Integer categoryId);

    /**
     * 类别修改功能
     * @param category
     * @return
     * */
    R adminUpdate(Category category);
}
