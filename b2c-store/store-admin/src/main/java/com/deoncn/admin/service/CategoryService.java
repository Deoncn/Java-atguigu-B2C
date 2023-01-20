package com.deoncn.admin.service;

import com.deoncn.param.PageParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;

/**
 * ClassName:CategoryService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 18:44
 * @Version: v1.0
 */
public interface CategoryService {


 /**
  *  分页查询方法
  * @param pageParam
  * @return
  * */
 R pageList(PageParam pageParam);


 /**
  *
  * 分类数据添加
  * @param category
  * @return
  *
  *
  * */
 R save(Category category);


 /**
  * 根据id 删除类别数据
  * @param categoryId
  * @return
  * */
 R remove(Integer categoryId);


 /**
  * 修改类别信息
  * @param category
  * @return
  * */
 R update(Category category);
}
