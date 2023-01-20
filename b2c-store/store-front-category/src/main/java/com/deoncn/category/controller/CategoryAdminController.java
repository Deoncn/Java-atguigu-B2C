package com.deoncn.category.controller;

import com.deoncn.category.service.CategoryService;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:CategoryAdminController
 * Package: IntelliJ IDEA
 * Description: 后台分类管理
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 18:38
 * @Version: v1.0
 */

@RestController
@RequestMapping("/category")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("admin/list")
    public R listPage(@RequestBody PageParam pageParam) {

        return categoryService.listPage(pageParam);
    }

    @PostMapping("admin/save")
    public R adminSave(@RequestBody Category category) {

        return categoryService.adminSave(category);
    }

    @PostMapping("admin/remove")
    public R adminRemove(@RequestBody Integer categoryId) {

        return categoryService.adminRemove(categoryId);
    }

    @PostMapping("admin/update")
    public R adminUpdate(@RequestBody Category category) {

        return categoryService.adminUpdate(category);
    }







}
