package com.deoncn.admin.service.impl;

import com.deoncn.admin.service.OrderService;
import com.deoncn.clients.OrderClient;
import com.deoncn.param.PageParam;
import com.deoncn.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:OrderServiceImpl
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/8 - 19:57
 * @Version: v1.0
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

 @Autowired
 private OrderClient orderClient;

 /**
  * 后台 订单查询数据
  *
  * @param pageParam
  * @return
  */
 @Override
 public R list(PageParam pageParam) {

  R r = orderClient.list(pageParam);

  log.info("OrderServiceImpl.list 业务结束，结果：{}",r);

  return r;
 }
}
