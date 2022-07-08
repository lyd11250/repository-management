package com.lyd.management.dao;

import com.lyd.management.model.Inventory;
import com.lyd.management.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Select("select id,good_id,repo_id,num,time from records")
    List<Record> selectAll();
}
