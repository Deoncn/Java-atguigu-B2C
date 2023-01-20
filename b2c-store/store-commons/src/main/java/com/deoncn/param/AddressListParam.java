package com.deoncn.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:AddressListParam
 * Package: IntelliJ IDEA
 * Description: 地址集合参数接收
 *
 * @Author: Deoncn
 * @Create: 2023/1/2 - 14:00
 * @Version: v1.0
 */

@Data
public class AddressListParam {


    @NotNull
    @JsonProperty("user_id")
    private Integer userId;

}
