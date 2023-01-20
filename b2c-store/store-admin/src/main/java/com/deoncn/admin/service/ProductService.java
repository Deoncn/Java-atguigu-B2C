

package com.deoncn.admin.service;

import com.deoncn.param.ProductSaveParam;
import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;

/**
 * ClassName:ProductService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 2:37
 * @Version: v1.0
 */
public interface ProductService {


    /**
     * 全部商品查询和搜索的放啊
     *
     * @param productSearchParam
     * @return
     */
    R search(ProductSearchParam productSearchParam);


    /**
     * 进行商品数据保存
     *
     * @param productSaveParam
     * @return
     */
    R save(ProductSaveParam productSaveParam);


    /**
     * 更新商品数据
     *
     * @param product
     * @return
     */
    R update(Product product);


    /**
     *  商品移除功能
     * @param productId
     * @return
     *
     *
     * */

    R remove(Integer productId);
}
