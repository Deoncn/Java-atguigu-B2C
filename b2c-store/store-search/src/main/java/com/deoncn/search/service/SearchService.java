package com.deoncn.search.service;

import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;

import java.io.IOException;

/**
 * ClassName:SearchService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 15:02
 * @Version: v1.0
 */
public interface SearchService {

 /**
  * 根据关键字和分页进行数据库数据查询
  * @param productSearchParam
  * @return
  * */
 R search(ProductSearchParam productSearchParam);

 /**
  * 商品同步：插入和更新
  * @param product
  * @return
  * */
    R save(Product product) throws IOException;

    /**
     * 进行es 库的商品删除
     * @param productId
     * @return
     * */
    R remove(Integer productId) throws IOException;
}
