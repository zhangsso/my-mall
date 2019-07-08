package com.zhangs.productservice.service;

import com.zhangs.productservice.entity.ProduceEntity;

import java.util.List;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 17:49 2019/7/8
 */
public interface ProduceService {

    ProduceEntity findById(String id);

    List<ProduceEntity> findAll();
}
