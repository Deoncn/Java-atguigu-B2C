package com.deoncn.admin.controller;

import com.deoncn.admin.service.CategoryService;
import com.deoncn.param.PageParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:CategoryController
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 18:43
 * @Version: v1.0
 */

@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    public R pageList(PageParam pageParam) {

        return categoryService.pageList(pageParam);
    }

    @PostMapping("save")
    public R save(Category category) {

        return categoryService.save(category);
    }

    @PostMapping("remove")
    public R remove(Integer categoryId){

        return categoryService.remove(categoryId);
    }

    @PostMapping("update")
    public R update(Category category){

        return categoryService.update(category);
    }


}
