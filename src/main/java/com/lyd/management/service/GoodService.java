package com.lyd.management.service;

import com.lyd.management.model.Good;

import java.util.List;

public interface GoodService {
    List<Good> selectAllService();
    boolean deleteByIdService(int id);
    boolean addGoodService(Good good);
    boolean editGoodService(Good good);

}
