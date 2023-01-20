package com.deoncn.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * ClassName:ProductHotParam
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Deoncn
 * @Create: 2023/1/3 - 4:53
 * @Version: v1.0
 */

@Data
public class ProductHotParam {

    @NotEmpty
    private List<String> categoryName;
}
