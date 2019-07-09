package com.zhangs.orderservice.feignClients;

import com.zhangs.orderservice.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 14:55 2019/7/9
 */
@FeignClient("product-server")
public interface ProductFeiginClient {

    //如果被调用方使用requestMapping，这边必须使用PostMapping
    //参数列表，应该加上@RequestParam
    @PostMapping("/product/findById")
    R findById(@RequestParam("id") String id);
}
