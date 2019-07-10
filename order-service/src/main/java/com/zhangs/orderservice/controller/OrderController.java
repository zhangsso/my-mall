package com.zhangs.orderservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangs.orderservice.common.utils.R;
import com.zhangs.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 11:03 2019/7/9
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrder")
    public R getOrder(String orderId){
        return orderService.getOrderById(orderId);
    }


}
