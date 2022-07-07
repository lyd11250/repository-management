package com.lyd.management.service;

import com.lyd.management.model.Good;

import java.util.List;

public interface GoodService {
    List<Good> selectAllService();
    Good selectByIdService(int id);
    boolean deleteByIdService(int id);
    boolean addGoodService(Good good);
    boolean editGoodService(Good good);

}
