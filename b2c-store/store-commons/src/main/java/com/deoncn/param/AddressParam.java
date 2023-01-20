package com.deoncn.param;

import com.deoncn.pojo.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:AddressParam
 * Package: IntelliJ IDEA
 * Description: 地址接收 值的 param
 *
 * @Author: Deoncn
 * @Create: 2023/1/7 - 13:25
 * @Version: v1.0
 */

@Data
public class AddressParam {

    @JsonProperty("user_id")
    @NotNull
    private Integer userId;

    private Address add;

}
