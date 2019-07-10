package com.zhangs.productservice.controller;


import com.zhangs.productservice.common.utils.R;
import com.zhangs.productservice.entity.ProduceEntity;
import com.zhangs.productservice.service.ProduceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    //为了验证ribbin的负载均衡
    @Value("${server.port}")
    private String port;

    @RequestMapping("/findById")
    public R findById(String id){
        ProduceEntity byId = produceService.findById(id);

        try {
            //模拟休眠5秒
            TimeUnit.SECONDS.sleep(3);//
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok().put("data",byId).put("port",port);
    }



    @RequestMapping("/findAll")
    public R findAll(){
        List<ProduceEntity> all = produceService.findAll();
        return R.ok().put("data",all);
    }


}
