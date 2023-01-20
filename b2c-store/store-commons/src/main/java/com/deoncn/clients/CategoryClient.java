package com.deoncn.clients;

import com.deoncn.param.PageParam;
import com.deoncn.param.ProductHotParam;
import com.deoncn.pojo.Category;
import com.deoncn.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:CategoryClient
 * Package: IntelliJ IDEA
 * Description: 类别调用接口
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 20:26
 * @Version: v1.0
 */

@FeignClient("category-service")
public interface CategoryClient {

    @GetMapping("/category/promo/{categoryName}")
    R byName(@PathVariable String categoryName);

    @PostMapping("/category/hots")
    R hots(@RequestBody ProductHotParam productHotParam);

    @GetMapping("/category/list")
    R list();

    @PostMapping("/category/admin/list")
    R adminPageList(@RequestBody PageParam pageParam);

    @PostMapping("/category/admin/save")
    R adminSave(@RequestBody Category category);

    @PostMapping("/category/admin/remove")
    R adminRemove(@RequestBody Integer categoryId);

    @PostMapping("/category/admin/update")
    R adminUpdate(@RequestBody Category category);


}
