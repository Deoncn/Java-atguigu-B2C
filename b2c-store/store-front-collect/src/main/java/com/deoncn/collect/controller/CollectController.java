package com.deoncn.collect.controller;

import com.deoncn.collect.service.CollectService;
import com.deoncn.pojo.Collect;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:CollectController
 * Package: IntelliJ IDEA
 * Description: 收藏 controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 12:10
 * @Version: v1.0
 */
@RestController
@RequestMapping("collect")
public class CollectController {

    @Autowired
    private CollectService collectService;


    @PostMapping("save")
    public R save(@RequestBody Collect collect) {

        return collectService.save(collect);
    }

    @PostMapping("list")
    public R list(@RequestBody Collect collect) {
        return collectService.list(collect.getUserId());
    }

    @PostMapping("remove")
    public R remove(@RequestBody Collect collect) {
        return collectService.remove(collect);
    }


    @PostMapping("remove/product")
    public R remove(@RequestBody Integer productId) {
        return collectService.removeByPid(productId);
    }


}
