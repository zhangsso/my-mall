package com.zhangs.orderservice.feignClientFallBack;

import com.zhangs.orderservice.common.utils.R;
import com.zhangs.orderservice.feignClients.ProductFeiginClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 10:58 2019/7/10
 */
@Component
public class ProductFeignClientFallBack implements ProductFeiginClient {

    @Override
    @PostMapping("/product/findById")
    public R findById(String id) {
        return R.error("已降级");
    }
}
