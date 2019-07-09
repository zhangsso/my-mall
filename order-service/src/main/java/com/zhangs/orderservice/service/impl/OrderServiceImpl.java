package com.zhangs.orderservice.service.impl;

import com.zhangs.orderservice.common.utils.R;
import com.zhangs.orderservice.feignClients.ProductFeiginClient;
import com.zhangs.orderservice.service.OrderService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 11:04 2019/7/9
 */
@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductFeiginClient productFeiginClient;

    @Override
    public R getOrderById(String id) {
        //根据订单id获取商品信息
//        String forObject = restTemplate.getForObject("http://product-server/product/findById?id=" + id, String.class);
        R byId = productFeiginClient.findById(id);
        return byId;


    }
}
