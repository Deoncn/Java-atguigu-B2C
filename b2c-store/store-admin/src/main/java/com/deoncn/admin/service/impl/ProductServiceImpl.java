package com.deoncn.admin.service.impl;

import com.deoncn.admin.service.ProductService;
import com.deoncn.clients.ProductClient;
import com.deoncn.clients.SearchClient;
import com.deoncn.param.ProductSaveParam;
import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:ProductServiceImpl
 * Package: IntelliJ IDEA
 * Description: 商品服务实现类
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 2:44
 * @Version: v1.0
 */


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private SearchClient searchClient;

    /**
     * 全部商品查询和搜索的放啊
     *
     * @param productSearchParam
     * @return
     */
    @Override
    public R search(ProductSearchParam productSearchParam) {
        R search = searchClient.search(productSearchParam);
        log.info("ProductServiceImpl.search业务结束，结果：{}", search);

        return search;
    }

    /**
     * 进行商品数据保存
     *
     * @param productSaveParam
     * @return
     */
    @Override
    public R save(ProductSaveParam productSaveParam) {

        R r = productClient.adminCount(productSaveParam);

        log.info("ProductServiceImpl.save 业务结束，结果：{}", r);
        return r;
    }

    /**
     * 更新商品数据
     *
     * @param product
     * @return
     */
    @Override
    public R update(Product product) {

        R r = productClient.adminUpdate(product);

        log.info("ProductServiceImpl.update 业务结束，结果:{}", r);

        return r;
    }

    /**
     * 商品移除功能
     *
     * @param productId
     * @return
     */
    @Override
    public R remove(Integer productId) {

        R r = productClient.adminRemove(productId);
        log.info("ProductServiceImpl.remove 业务结束，结果：{}", r);
        return r;
    }
}
