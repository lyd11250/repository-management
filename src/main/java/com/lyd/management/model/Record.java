package com.lyd.management.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Record {
    private Integer id;
    private Integer goodId;
    private Integer repoId;
    private Integer num;
    private Timestamp time;
}
