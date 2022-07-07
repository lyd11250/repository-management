package com.lyd.management.dao;

import com.lyd.management.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return employee对象
     * @author wr1sw
     */
    Employee loadEmpByUsername(String username);

    /**
     * 向数据库中增添employee数据
     * @param employee
     * @return 增添结果
     * @author wr1sw
     */
    int doReg(Employee employee);

    /**
     * 查询指定用户状态的员工集合
     * @param status 指定状态
     * @return 员工集合
     */
    List<Employee> getAllEmpsByStatus(Integer status);

    /**
     * 查询指定用户状态的员工集合，通过分页的方式显示
     * @param page 当前页
     * @param pageSize 页大小
     * @param status 指定状态
     * @return
     * @author wr1sw
     */
    List<Employee> getAllEmpsByStatusPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
                                          @Param("status") Integer status);

    /**
     * 更新指定员工的账号状态
     * @param employeeId 指定员工id
     * @param status 目标状态
     * @return 更新结果
     * @author wr1sw
     */
    Integer updateStatus(@Param("employeeId") Integer employeeId, @Param("status") Integer status);

    /**
     * 获取指定id员工信息
     * @param employeeId id
     * @return 员工信息
     * @author wr1sw
     */
    Employee getEmpById(Integer employeeId);


    /**
     * 查询指定部门的所有员工信息
     * @param depId 部门id
     * @return 查询结果
     * @author wr1sw
     */
    List<Employee> getEmpsByDepId(Integer depId);


    /**
     * 通过限定条件查询符合条件的员工信息
     * @param employee 限定条件
     * @param page 当前页
     * @param pageSize 页大小
     * @return 查询结果
     * @author wr1sw
     */
    List<Employee> queryAllEmpsByEntity(@Param("emp") Employee employee, @Param("page") Integer page,
                                        @Param("pageSize") Integer pageSize);


    /**
     * 删除指定id员工
     * @param employeeId 指定id
     * @return 删除结果
     * @author wr1sw
     */
    Integer delEmpById(Integer employeeId);
}
