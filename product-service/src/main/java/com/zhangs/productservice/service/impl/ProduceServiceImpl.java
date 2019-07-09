package com.zhangs.productservice.service.impl;

import com.zhangs.productservice.entity.ProduceEntity;
import com.zhangs.productservice.service.ProduceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 17:49 2019/7/8
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    private Map<String,ProduceEntity> map = new HashMap<>();



    @Override
    public ProduceEntity findById(String id) {
        return map.get(id);
    }

    @Override
    public List<ProduceEntity> findAll() {
        map.put("1",new ProduceEntity("1","iphone8",new BigDecimal(4592),"玫瑰金"));
        map.put("2",new ProduceEntity("2","iphone8 plus",new BigDecimal(5269),"玫瑰金"));
        map.put("3",new ProduceEntity("3","iphonexs",new BigDecimal(87820),"玫瑰金"));
        map.put("4",new ProduceEntity("4","iphonexr",new BigDecimal(5900),"玫瑰金"));
        Collection<ProduceEntity> values = map.values();
        List<ProduceEntity> list = new ArrayList<ProduceEntity>(values);
        return list;
    }
}
