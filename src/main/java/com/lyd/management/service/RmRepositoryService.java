package com.lyd.management.service;

import com.lyd.management.model.RmRepository;

import java.util.List;

public interface RmRepositoryService {
    //定义一些抽象的方法
    //获取所有的用户列表数据
    List<RmRepository> getRepositoryList();
    Boolean removerRepositoryService(int id);
    boolean addRepositoryService(RmRepository rmRepository);
    boolean editRepositoryService(RmRepository rmRepository);
}
