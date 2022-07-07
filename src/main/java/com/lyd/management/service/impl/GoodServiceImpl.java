package com.lyd.management.service.impl;

import com.lyd.management.dao.GoodMapper;
import com.lyd.management.model.Good;
import com.lyd.management.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;
    @Override
    public List<Good> selectAllService() {
        return goodMapper.selectAll();
    }

    @Override
    public boolean deleteByIdService(int id) {
        return goodMapper.deleteById(id);
    }

    @Override
    public boolean addGoodService(Good good) {
        return goodMapper.addGood(good);
    }

    @Override
    public boolean editGoodService(Good good) {
        return goodMapper.editGood(good);
    }
}
