package com.deoncn.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deoncn.clients.*;
import com.deoncn.param.ProductHotParam;
import com.deoncn.param.ProductIdsParam;
import com.deoncn.param.ProductSaveParam;
import com.deoncn.param.ProductSearchParam;
import com.deoncn.pojo.Picture;
import com.deoncn.pojo.Product;
import com.deoncn.product.mapper.PictureMapper;
import com.deoncn.product.mapper.ProductMapper;
import com.deoncn.product.service.ProductService;
import com.deoncn.to.OrderToProduct;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName:ProductApplicationImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 20:36
 * @Version: v1.0
 */

@Service
@Slf4j
public class ProductApplicationImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {


    @Autowired
    private SearchClient searchClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private CartClient cartClient;

    @Autowired
    private CollectClient collectClient;


    @Autowired
    private ProductMapper productMapper;

    // 引入feign 客户端， 需要在启动类添加配置注解
    @Autowired
    private CategoryClient categoryClient;


    @Autowired
    private PictureMapper pictureMapper;


    /**
     * 根据单类别名称查询热门商品 最多7条数据
     * 1. 根据类别名称 调用 feign 客户端访问类别服务获取类别的数据
     * 2. 成功 -> 继续根据类别id 查询商品数据 【热门， 销售额数据，查询7条】
     * 3. 结果封装
     *
     * @param categoryName 类别名称
     * @return R
     */
    @Override
    @Cacheable(value = "list.product", key = "#categoryName", cacheManager = "cacheManagerDay")
    public R promo(String categoryName) {
        R r = categoryClient.byName(categoryName);

        if (r.getCode().equals(R.FAIL_CODE)) {
            log.info("ProductServiceImpl.promp 业务结束，结果：{}", "类别查询失败！");
            return r;
        }

        // 类别服务中 data = category --- feign {json} ----- product 服务 默认转换成 LinkedHashMap jackson
        // 类型转换问题 feign 等
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) r.getData();
        // 属性名问题 需要修改
        Integer categoryId = (Integer) map.get("category_id");

        // 封装查询参数
        QueryWrapper<Product> querywrapper = new QueryWrapper<>();
        querywrapper.eq("category_id", categoryId);
        querywrapper.orderByDesc("product_sales");

        IPage<Product> page = new Page<>(1, 7);

        page = productMapper.selectPage(page, querywrapper);

        List<Product> productList = page.getRecords();
        long total = page.getTotal(); // 获取总条数

        log.info("ProductServiceImpl.promo 业务结束， 结果：{}", productList);
        return R.ok("数据查询成功", productList);
    }


    /**
     * 多类别热门商品查询 根据类别名称集合！ 至多查询7条
     * 1.调用类别服务
     * 2.类别集合id查询商品
     * 3.结果及 封装
     *
     * @param productHotParam 类别名称集合
     * @return R
     */
    @Override
    @Cacheable(value = "list.product", key = "#productHotParam.categoryName")
    public R hots(ProductHotParam productHotParam) {

        R r = categoryClient.hots(productHotParam);

        if (r.getCode().equals(R.FAIL_CODE)) {
            log.info("ProductServiceImpl.hots 业务结束，结果：{}", r.getMsg());
            return r;
        }
        List<Object> ids = (List<Object>) r.getData();

        // 进行商品数据查询
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("category_id", ids);
        queryWrapper.orderByDesc("product_sales");


        IPage<Product> page = new Page<>(1, 7);
        page = productMapper.selectPage(page, queryWrapper);

        List<Product> records = page.getRecords();
        R ok = R.ok("多类别热门商品查询成功！", records);

        log.info("ProductServiceImpl.hots 业务结束，结果：{}", ok);
        return ok;
    }

    /**
     * 查询类别商品集合
     *
     * @return
     */
    @Override
    public R clist() {
        R r = categoryClient.list();
        log.info("ProductServiceImpl.clist 业务结束,结果：{}", r);

        return r;
    }

    /**
     * 通用性的业务
     * 传入了id，根据id 查询并且分页
     * 没有传入类别的id，查询全部
     *
     * @param productIdsParam
     * @return
     */
    @Override
    @Cacheable(value = "list.product", key = "#productIdsParam.categoryID+'-'+#productIdsParam.currentPage+'-'+#productIdsParam.pageSize")
    public R bycategory(ProductIdsParam productIdsParam) {

        List<Integer> categoryID = productIdsParam.getCategoryID();
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (!categoryID.isEmpty()) {
            queryWrapper.in("category_id", categoryID);
        }

        IPage<Product> page = new Page<>(productIdsParam.getCurrentPage(), productIdsParam.getPageSize());

        page = productMapper.selectPage(page, queryWrapper);

        // 结果集封装
        R ok = R.ok("查询成功！", page.getRecords(), page.getTotal());
        log.info("ProductServiceImpl.byCategory 业务结束，结果：{}", ok);

        return ok;
    }

    /**
     * 根据商品 id 查询商品详情信息
     *
     * @param productID
     * @return
     */
    @Override
    @Cacheable(value = "product", key = "#productID")
    public R detail(Integer productID) {
        Product product = productMapper.selectById(productID);

        R ok = R.ok(product);
        log.info("ProductServiceImpl.detail 业务结束,结果：{}", ok);

        return ok;
    }

    /**
     * 查询 商品对应的图片详情集合
     *
     * @param productID
     * @return
     */
    @Override
    @Cacheable(value = "picture", key = "#productID")
    public R pictures(Integer productID) {
        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("product_id", productID);

        List<Picture> pictureList = pictureMapper.selectList(queryWrapper);

        R ok = R.ok(pictureList);


        log.info("ProductServiceImpl.pictures 业务结束,结果:{}", ok);
        return ok;
    }

    /**
     * 搜索服务调用，获取全部商品数据
     * 进行同步
     *
     * @return 商品数据集合
     */
    @Override
    @Cacheable(value = "list.category", key = "#root.methodName", cacheManager = "cacheManagerDay")
    public List<Product> allList() {
        List<Product> productList = productMapper.selectList(null);

        log.info("ProductServiceImpl.allList 业务结束，结果：{}", productList.size());
        return productList;
    }

    /**
     * 搜索业务，需要调用搜索服务！
     *
     * @param productSearchParam
     * @return
     */
    @Override
    public R search(ProductSearchParam productSearchParam) {
        R r = searchClient.search(productSearchParam);
        log.info("ProductServiceImpl.search 业务结束，结果：{}", r);

        return r;
    }


    /**
     * 根据商品id集合 查询商品信息
     *
     * @param productIds
     * @return
     */
    @Override
    @Cacheable(value = "list.product", key = "#productIds")
    public R ids(List<Integer> productIds) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id", productIds);

        List<Product> productList = productMapper.selectList(queryWrapper);
        R r = R.ok("类别信息查询成功！", productList);
        log.info("ProductServiceImpl.ids 业务结束，结果:{}", r);

        return r;
    }

    /**
     * 根据商品ID，查询商品id 集合
     *
     * @param productIds
     * @return
     */
    @Override
    public List<Product> cartList(List<Integer> productIds) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id", productIds);

        List<Product> productList = productMapper.selectList(queryWrapper);
        log.info("ProductServiceImpl.cartList 业务结束，结果：{}", productList);
        return productList;
    }

    /**
     * 修改库存 ，增加销售量
     *
     * @param orderToProductList
     */
    @Override
    public void subNumber(List<OrderToProduct> orderToProductList) {
        // 将集合转成 map productId orderToProduct
        Map<Integer, OrderToProduct> map = orderToProductList.stream().collect(Collectors.toMap(OrderToProduct::getProductId, v -> v));
        //  获取商品的id 集合
        Set<Integer> productIds = map.keySet();
        //查询集合对应的商品信息
        List<Product> productList = productMapper.selectBatchIds(productIds);
        //修改信息
        for (Product product : productList) {
            Integer num = map.get(product.getProductId()).getNum();
            product.setProductNum(product.getProductNum() - num);
            product.setProductSales(product.getProductSales() + num);
        }
        //批量更新
        this.updateBatchById(productList);
        log.info("ProductServiceImpl.subNumber 业务结束，结果：库存和销售量的修改完毕");

    }


    /**
     * 类别对应的数量查询
     *
     * @param categoryId
     * @return
     */
    @Override
    public Long adminCount(Integer categoryId) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);

        Long count = baseMapper.selectCount(queryWrapper);
        log.info("ProductServiceImpl.adminCount 业务结束，结果：{}", count);
        return count;
    }

    /****
     * 商品保存业务
     *  1.商品数据保存
     *  2.商品的图片详情切割和保存
     *  3.搜索数据的数据添加
     *  4.清空商品相关的缓存服务
     *
     * @param productSaveParam
     * @return
     *
     * */
    @Override
    @CacheEvict(value = "list.product", allEntries = true)
    public R adminSave(ProductSaveParam productSaveParam) {

        Product product = new Product();
        BeanUtils.copyProperties(productSaveParam, product);

        // 商品数据插入
        int rows = productMapper.insert(product);
        log.info("ProductServiceImpl.adminSave 业务结束,结果：{}", rows);

        // 商品图片获取 +
        String pictures = productSaveParam.getPictures();

        if (!StringUtils.isEmpty(pictures)) {
            // 截取特殊字符串的时候 \\ [] 包含 $ + * | ?
            String[] urls = pictures.split("\\+");
            for (String url : urls) {
                Picture picture = new Picture();
                picture.setProductId(product.getProductId());
                picture.setProductPicture(url);

                pictureMapper.insert(picture); // 插入商品的图片
            }


        }

        // 同步搜索服务数据
        searchClient.saveOrUpdate(product);


        return R.ok("商品数据添加成功");
    }


    /**
     * 商品数据更新
     * 1.更新商品数据
     * 2.同步搜索服务数据即可
     *
     * @param product
     * @return
     */
    @Override
    public R adminUpdate(Product product) {

        productMapper.updateById(product);

        //同步搜索服务的数据
        searchClient.saveOrUpdate(product);


        return R.ok("商品数据更新成功！");
    }


    /**
     * 商品删除业务
     * 1. 检查购物车
     * 2.检查订单
     * 3. 删除商品
     * 4. 删除商品相关的图片
     * 5.删除收藏
     * 6.进行 es 数据同步
     * 7. 清空缓存
     *
     * @param productId
     */
    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "product.list",allEntries = true),
                    @CacheEvict(value = "product",key = "#productId")
            }
    )
    public R adminRemove(Integer productId) {
        R r = cartClient.check(productId);

        if ("004".equals(r.getCode())) {
            log.info("ProductServiceImpl.adminRemove业务结束，结果:{}", r.getMsg());
            return r;
        }

        r = orderClient.check(productId);
        if ("004".equals(r.getCode())) {
            log.info("ProductServiceImpl.adminRemove业务结束，结果:{}", r.getMsg());
            return r;
        }

        // 删除商品
        productMapper.deleteById(productId);
        //删除商品图片
        QueryWrapper<Picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        pictureMapper.delete(queryWrapper);


        // 删除收藏中和本商品有关的！
        collectClient.remove(productId);

        //同步数据
        searchClient.remove(productId);


        return R.ok("商品删除成功！");
    }
}

