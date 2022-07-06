package com.lyd.management.model;

import lombok.Data;

@Data
public class Good {
    private Integer id;
    private String name;
    private Double price;
    private Integer supplier_id;
    private String intro;
}
