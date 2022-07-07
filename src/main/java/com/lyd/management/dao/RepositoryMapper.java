package com.lyd.management.dao;

import com.lyd.management.model.Good;
import com.lyd.management.model.RmRepository;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RepositoryMapper {
    @Select(value ={"select id,rm_name,rm_depart,rm_manager,rm_mphone,rm_area  from repository_info"})
    List<RmRepository> findRepoList();
    @Select("select id, rm_name, rm_depart, rm_manager, rm_mphone,rm_area from repository_info where id = #{id}")
    RmRepository selectRepoById(int id);
    @Delete(value = {"delete from repository_info WHERE id =#{id}"}) //#{id} -->#{参数名}
    Boolean deleteRepoById(int id);
    @Insert(value={"insert into repository_info(rm_name,rm_depart,rm_manager,rm_mphone,rm_area) " +
           "values(#{rmName},#{rmDepart},#{rmManager},#{rmMphone},#{rmArea})"})
    boolean saveRepo(RmRepository rmRepository);
    @Update(value = {"update repository_info set rm_name = #{rmName},rm_depart=#{rmDepart}," +
           "rm_manager= #{rmManager},rm_mphone= #{rmMphone},rm_area=#{rmArea} where id = #{id}" })
    boolean updateRepo(RmRepository rmRepository);
}
