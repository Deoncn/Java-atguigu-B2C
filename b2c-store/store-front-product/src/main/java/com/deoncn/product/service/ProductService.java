package com.deoncn.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deoncn.param.ProductHotParam;
import com.deoncn.param.ProductIdsParam;
import com.deoncn.param.ProductSaveParam;
import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Product;
import com.deoncn.to.OrderToProduct;
import com.deoncn.utils.R;

import java.util.List;

/**
 * ClassName:ProductService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 20:34
 * @Version: v1.0
 */
public interface ProductService extends IService<Product> {


    /**
     * 根据单类别名称查询热门商品 最多7条数据
     *
     * @param categoryName 类别名称
     * @return R
     */
    R promo(String categoryName);


    /**
     * 多类别热门商品查询 根据类别名称集合！ 至多查询7条
     *
     * @param productHotParam 类别名称集合
     * @return R
     */
    R hots(ProductHotParam productHotParam);


    /**
     * 查询类别商品集合
     *
     * @return
     */
    R clist();

    /**
     * 通用性的业务
     * 传入了id，根据id 查询并且分页
     * 没有传入类别的id，查询全部
     *
     * @param productIdsParam
     * @return
     */
    R bycategory(ProductIdsParam productIdsParam);


    /**
     * 根据商品 id 查询商品详情信息
     *
     * @param productID
     * @return
     */
    R detail(Integer productID);


    /**
     * 查询 商品对应的图片详情集合
     *
     * @param productID
     * @return
     */
    R pictures(Integer productID);


    /**
     * 搜索服务调用，获取全部商品数据
     * 进行同步
     *
     * @return 商品数据集合
     */
    List<Product> allList();


    /**
     * 搜索业务，需要调用搜索服务！
     *
     * @param productSearchParam
     * @return
     */
    R search(ProductSearchParam productSearchParam);

    /**
     * 根据商品id集合 查询商品信息
     *
     * @param productIds
     * @return
     */
    R ids(List<Integer> productIds);

    /**
     * 根据商品ID，查询商品id 集合
     *
     * @param productIds
     * @return
     */
    List<Product> cartList(List<Integer> productIds);

    /**
     * 修改库存 ，增加销售量
     *
     * @param orderToProductList
     */
    void subNumber(List<OrderToProduct> orderToProductList);

    /**
     * 类别对应的数量查询
     *
     * @param categoryId
     * @return
     */
    Long adminCount(Integer categoryId);

    /****
     * 商品保存业务
     * @param productSaveParam
     * @return
     *
     * */

    R adminSave(ProductSaveParam productSaveParam);

    /**
     * 商品数据更新
     *
     * @param product
     * @return
     */
    R adminUpdate(Product product);

    /**
     * 商品删除业务
     *
     * */
    R adminRemove(Integer productId);
}
