package com.deoncn.param;

import lombok.Data;

/**
 * ClassName:PageParam
 * Package: IntelliJ IDEA
 * Description: 分页属性
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 14:58
 * @Version: v1.0
 */
@Data
public class PageParam {

 private int currentPage = 1; // 默认值 1
 private int pageSize = 15; //默认值 15

}
