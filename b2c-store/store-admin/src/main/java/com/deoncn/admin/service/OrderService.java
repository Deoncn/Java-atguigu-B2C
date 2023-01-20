package com.deoncn.admin.service;

import com.deoncn.param.PageParam;
import com.deoncn.utils.R;

/**
 * ClassName:OrderService
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 19:56
 * @Version: v1.0
 */
public interface OrderService {


 /**
  * 后台 订单查询数据
  * @param pageParam
  * @return
  *
  * */
 R list(PageParam pageParam);
}
