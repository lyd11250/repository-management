package com.lyd.management.dao;

import com.lyd.management.model.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {

    List<Good> selectAll();

    @Select("select id, name, price, supplier_id, intro from goods where id = #{id}")
    Good selectById(int id);

    @Delete("delete from goods where id = #{id}")
    boolean deleteById(int id);

    @Insert("insert into goods(name, price, supplier_id, intro) " +
            "values(#{name},#{price},#{supplierId},#{intro})")
    boolean addGood(Good good);

    @Update("update goods set name = #{name}, price = #{price}, supplier_id = #{supplierId}, intro = #{intro} " +
            "where id = #{id}")
    boolean editGood(Good good);
}
