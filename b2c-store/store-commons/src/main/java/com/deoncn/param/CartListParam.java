package com.deoncn.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName:CartListParam
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/6 - 15:46
 * @Version: v1.0
 */

@Data
public class CartListParam {


    @JsonProperty("user_id")
    @NotNull
    private Integer userId;

}
