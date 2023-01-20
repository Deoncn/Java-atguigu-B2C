package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:AddressRemoveParam
 * Package: IntelliJ IDEA
 * Description: 地址移除参数
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 15:50
 * @Version: v1.0
 */
@Data
public class AddressRemoveParam {

    @NotNull
    private Integer id;

}
