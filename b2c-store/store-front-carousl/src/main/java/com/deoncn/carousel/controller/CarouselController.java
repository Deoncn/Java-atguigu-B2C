package com.deoncn.carousel.controller;

import com.deoncn.carousel.service.CarouselService;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:CarouselController
 * Package: IntelliJ IDEA
 * Description: 轮播图的控制类
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 17:26
 * @Version: v1.0
 */

@RestController
@RequestMapping("carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;


    @PostMapping("list")
    public R list() {

        return carouselService.list();
    }
}
