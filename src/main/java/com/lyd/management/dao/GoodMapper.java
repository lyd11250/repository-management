package com.lyd.management.dao;

import com.lyd.management.model.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    List<Good> selectAll();
}
