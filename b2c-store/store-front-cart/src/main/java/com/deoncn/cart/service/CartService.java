package com.deoncn.cart.service;

import com.deoncn.param.CartSaveParam;
import com.deoncn.pojo.Cart;
import com.deoncn.utils.R;

import java.util.List;

/**
 * ClassName:CartService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 14:51
 * @Version: v1.0
 */
public interface CartService {


 /**
  * 购物车 数据添加方法
  * @param cartSaveParam
  * @return 001 - 成功 002 - 已存在 003 - 无库存
  * */
 R save(CartSaveParam cartSaveParam);

 /**
  * 返回购物车数据
  * @param userId
  * @return 确保要返回一个数组或 集合
  * */
 R list(Integer userId);

 /**
  * 更新购物车
  * @param cart
  * @return
  * */
 R update(Cart cart);


/**
 *
 * 删除购物车
 * @param cart
 * @return
 * */
 R remove(Cart cart);

 /**
  * 清空对应id 的购物车项
  * @param cartIds
  *
  * */
 void clearIds(List<Integer> cartIds);

 /**
  *
  * 查询购物车项
  * @param productId
  * @return
  *
  * */
 R check(Integer productId);
}
