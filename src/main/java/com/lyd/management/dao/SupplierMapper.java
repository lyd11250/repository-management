package com.lyd.management.dao;

import com.lyd.management.model.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Select(value = {"select sp_id,sp_name,sp_con,sp_add,sp_phone,sp_goods from re_supplier"})
    List<Supplier> findSupplierList();
    @Delete(value = {"delete from re_supplier where sp_id = #{sp_id}"})
    Boolean deleteSupplierById(int spId);
    @Insert(value = {"insert into re_supplier(sp_name,sp_con,sp_add,sp_phone,sp_goods)" +
            " value(#{spName},#{spCon},#{spAdd},#{spPhone},#{spGoods}) "})
    boolean saveSupplier(Supplier supplier);
    @Update(value = {"update re_supplier set sp_name=#{spName},sp_con=#{spCon},sp_add=#{spAdd}," +
            "sp_phone=#{spPhone},sp_goods=#{spGoods} where sp_id = #{spId}"})
    boolean updateSupplier(Supplier supplier);
}
