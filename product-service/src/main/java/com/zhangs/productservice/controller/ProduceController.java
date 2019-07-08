package com.zhangs.productservice.controller;

import com.zhangs.productservice.common.utils.R;
import com.zhangs.productservice.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 17:27 2019/7/8
 */
@RestController
@RequestMapping("/product")
public class ProduceController {

    @Autowired
    private ProduceService produceService;

    public R findById(String id){
        return R.ok();
    }
}
