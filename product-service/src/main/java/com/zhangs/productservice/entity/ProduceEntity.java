package com.zhangs.productservice.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: zhangs
 * @Date: 17:50 2019/7/8
 */
@Data
public class ProduceEntity {

    private String id;
    private String name;
    private BigDecimal price;
    private String color;

    public ProduceEntity(String id, String name, BigDecimal price, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }
}
