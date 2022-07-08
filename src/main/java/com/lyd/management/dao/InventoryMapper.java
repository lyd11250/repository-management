package com.lyd.management.dao;

import com.lyd.management.model.Inventory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InventoryMapper {

    @Select("select good_id, repo_id, quantity from inventory")
    List<Inventory> selectAll();

    @Insert("insert into inventory(good_id, repo_id, quantity) " +
            "values(#{goodId},#{repoId},#{quantity})")
    boolean addInventory(Inventory inventory);

    @Update("update inventory set quantity = #{quantity} " +
            "where good_id=#{goodId} and repo_id=#{repoId}")
    boolean editInventory(Inventory inventory);

    @Update("update inventory set quantity = quantity + #{quantity} " +
            "where good_id=#{goodId} and repo_id=#{repoId}")
    boolean inAndOut(Inventory inventory);

    @Insert("insert into inventory(good_id,repo_id,quantity) " +
            "values(#{goodId},#{repoId},#{quantity}) " +
            "on duplicate key " +
            "update quantity = quantity + #{quantity}")
    boolean putIn(Inventory inventory);

    @Update("update inventory set quantity = quantity - #{quantity} " +
            "where good_id=#{goodId} and repo_id=#{repoId}")
    boolean putOut(Inventory inventory);
}
