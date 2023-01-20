package com.deoncn.cart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deoncn.cart.mapper.CartMapper;
import com.deoncn.cart.service.CartService;
import com.deoncn.clients.ProductClient;
import com.deoncn.param.CartSaveParam;
import com.deoncn.param.ProductCollectParam;
import com.deoncn.param.ProductIdParam;
import com.deoncn.pojo.Cart;
import com.deoncn.pojo.Product;
import com.deoncn.utils.R;
import com.deoncn.vo.CartVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName:CartServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 14:53
 * @Version: v1.0
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductClient productClient;

    /**
     * 购物车 数据添加方法
     *
     * @param cartSaveParam
     * @return 001 - 成功 002 - 已存在 003 - 无库存
     */
    @Override
    public R save(CartSaveParam cartSaveParam) {
        // 查询商品数据

        ProductIdParam productIdParam = new ProductIdParam();
        productIdParam.setProductID(cartSaveParam.getProductId());
        Product product = productClient.productDetail(productIdParam);
        if (product == null) {
            return R.fail("商品已经被删除，无法添加到购物车！");
        }
        //检查库存
        if (product.getProductNum() == 0) {
            R ok = R.ok("没有库存数据！无法购买");
            ok.setCode("003");
        }

        //检查是否添加过
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", cartSaveParam.getUserId());
        queryWrapper.eq("product_id", cartSaveParam.getProductId());
        Cart cart = cartMapper.selectOne(queryWrapper);

        if (cart != null) {
            // 购物车存在！
            //原有的数量+1
            cart.setNum(cart.getNum() + 1);
            cartMapper.updateById(cart);
            //返回002 提示即可
            R ok = R.ok("购物车存在该商品，数量+1");
            ok.setCode("002");
            log.info("CartServiceImpl.save业务结束，结果：{}", ok);
            return ok;
        }

        //添加购物车
        cart = new Cart();
        cart.setNum(1);
        cart.setUserId(cartSaveParam.getUserId());
        cart.setProductId(cartSaveParam.getProductId());

        int rows = cartMapper.insert(cart);
        log.info("CartServiceImpl.save业务结束，结果：{}", rows);

        CartVo cartVo = new CartVo(product, cart);

        //结果封装和返回

        return R.ok("购物车数据添加成功！", cartVo);
    }

    /**
     * 返回购物车数据
     *
     * @param userId
     * @return 确保要返回一个数组或 集合
     */
    @Override
    public R list(Integer userId) {
        // 1.根据用户id 查询购物车数据
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<Cart> carts = cartMapper.selectList(queryWrapper);

        //2.判断是否存在，不存在，返回一个空集合！

        if (carts == null || carts.size() == 0) {
            carts = new ArrayList<>(); //必须返回空数据
            return R.ok("购物车空空如也！", carts);
        }


        //3. 存在 获取商品的id 集合，并且调用商品查询
        List<Integer> productIds = new ArrayList<>();
        for (Cart cart : carts) {
            productIds.add(cart.getProductId());
        }

        ProductCollectParam productCollectParam = new ProductCollectParam();
        productCollectParam.setProductIds(productIds);
        List<Product> productList = productClient.cartList(productCollectParam);

        // 商品集合 ->（转换为） 商品 id = key   ，，，商品 = value
        // jdk 8 stream jdk8 新特性
        Map<Integer, Product> productMap = productList.stream().collect(Collectors.toMap(Product::getProductId, v -> v));
        //4.进行vo封装
        List<CartVo> cartVoList = new ArrayList<>();

        for (Cart cart : carts) {
            CartVo cartVo = new CartVo(productMap.get(cart.getProductId()), cart);
            cartVoList.add(cartVo);

        }
        R r = R.ok("数据库数据查询成功！", cartVoList);
        log.info("CartServiceImpl.list业务结束，结果：{}", r);

        return r;
    }

    /**
     * 更新购物车
     * 1.查询商品数据
     * 2.判断库存是否可用
     *
     * @param cart
     * @return
     */
    @Override
    public R update(Cart cart) {

        //1.查
        ProductIdParam productIdParam = new ProductIdParam();
        productIdParam.setProductID(cart.getProductId());
        Product product = productClient.productDetail(productIdParam);

        //2.判断
        if (cart.getNum() > product.getProductNum()) {
            log.info("CartServiceImpl.update 业务结束，结果：{}", "修改失败！ 库存不足！");
            return R.fail("修改失败！ 库存不足！");
        }
        // 修改数据库
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", cart.getUserId());
        queryWrapper.eq("product_id", cart.getProductId());
        Cart newCart = cartMapper.selectOne(queryWrapper);
        newCart.setNum(cart.getNum());
        int rows = cartMapper.updateById(newCart);
        log.info("CartServiceImpl.update 业务结束，结果:{}", rows);

        return R.ok("修改购物车数量成功！");
    }

    /**
     * 删除购物车
     *
     * @param cart
     * @return
     */
    @Override
    public R remove(Cart cart) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", cart.getUserId());
        queryWrapper.eq("product_id", cart.getProductId());

        int rows = cartMapper.delete(queryWrapper);
        log.info("CartServiceImpl.remove 业务结束，结果:{}", rows);
        return R.ok("删除购物车数据成功！");
    }

    /**
     * 清空对应id 的购物车项
     *
     * @param cartIds
     */
    @Override
    public void clearIds(List<Integer> cartIds) {

        cartMapper.deleteBatchIds(cartIds);

        log.info("CartServiceImpl.clearIds 业务结束，结果：{}", cartIds);
    }

    /**
     * 查询购物车项
     *
     * @param productId
     * @return
     */
    @Override
    public R check(Integer productId) {


        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);

        Long count = cartMapper.selectCount(queryWrapper);
        if (count > 0) {
            return R.fail("有："+ count +"件购物车商品引用！删除失败！");
        }

        return R.ok("购物车无商品引用！");
    }
}
