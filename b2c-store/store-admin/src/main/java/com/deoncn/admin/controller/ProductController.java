package com.deoncn.admin.controller;

import com.deoncn.admin.service.ProductService;
import com.deoncn.admin.utils.AliyunOSSUtils;
import com.deoncn.param.ProductSaveParam;
import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * ClassName:ProductController
 * Package: IntelliJ IDEA
 * Description: 商品后台管理 Controller
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 2:35
 * @Version: v1.0
 */

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private AliyunOSSUtils aliyunOSSUtils;

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public R adminList(ProductSearchParam productSearchParam) {

        return productService.search(productSearchParam);
    }

    @PostMapping("upload")
    public R adminUpload(@RequestParam MultipartFile img) throws Exception {

        String filename = img.getOriginalFilename();
        filename = UUID.randomUUID().toString().replace("-", "")
                + filename;

        String contentType = img.getContentType();
        byte[] content = img.getBytes();
        int hours = 1000;

        String url = aliyunOSSUtils.uploadImage(filename, content, contentType, hours);
        System.out.println("url = " + url);

        return R.ok("图片上传成功",url);
    }

    @PostMapping("save")
    public R adminSave(ProductSaveParam productSaveParam){
        return productService.save(productSaveParam);
    }

    @PostMapping("update")
    public R adminUpdate(Product product){
        return productService.update(product);
    }


    @PostMapping("remove")
    public R adminRemove(Integer productId){
        return productService.remove(productId);
    }


}
