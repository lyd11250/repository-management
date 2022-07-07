package com.lyd.management.service;


import com.lyd.management.dao.EmployeeMapper;
import com.lyd.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    /**
     * 执行登录
     * @param username 搜索框输入的用户名
     * @param password 搜索框输入的密码
     * @return 登录成功：返回登录对象；登录失败：返回null
     * @author wr1sw
     */
    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUsername(username);
        System.out.println("employee = " + employee);
        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }
        return employee;
    }


    /**
     * 执行注册
     * @param employee 前端输入的注册信息(employee对象)
     * @return 注册成功，返回 1 | 注册失败：返回 -1
     * @author wr1sw
     */
    public int doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUserName());
        if (emp != null) {
            return -1;
        }
        // 设置账户级别为普通用户
//        employee.setRole(1);
        // 设置改账户状态为未审批
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    /**
     * 获取指定状态的所有员工信息
     * @param status 指定状态
     * @return 返回查询结果
     * @author wr1sw
     */
    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    /**
     * 获取指定状态的所有员工信息；分页方法
     * @param page 当前页
     * @param pageSize 当前页大小
     * @param status 指定状态
     * @return 查询结果
     * @author wr1sw
     */
    public List<Employee> getAllEmpsByStatus(Integer page, Integer pageSize, Integer status) {
        // 页号偏移
        page = (page-1)*pageSize;
        return employeeMapper.getAllEmpsByStatusPage(page,pageSize,status);
    }

    /**
     * 更新指定员工账户的状态为目标状态
     * @param employeeId 指定员工id
     * @param status    目标状态
     * @return 返回更新结果
     * @author wr1sw
     */
    public Integer updateStatus(Integer employeeId, Integer status) {
        return employeeMapper.updateStatus(employeeId, status);
    }

    /**
     * 获取指定员工数据
     * @param employeeId 指定员工id
     * @return 查询结果
     * @author wr1sw
     */
    public Employee getEmpById(Integer employeeId) {
        return employeeMapper.getEmpById(employeeId);
    }

    /**
     * 获取指定部门的所有员工数据
     * @param depId 指定部门id
     * @return 查询结果
     * @author wr1sw
     */
    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }

    /**
     * 获取所有员工信息；分页方法
     * @param employee 限定查询条件(搜索框输入)
     * @param page 当前页
     * @param pageSize 页大小
     * @return 返回查询数据
     * @author wr1sw
     */
    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        // 页号偏移
        page = (page-1) * pageSize;
        return employeeMapper.queryAllEmpsByEntity(employee,page, pageSize);
    }

    /**
     * 删除指定员工
     * @param employeeId 指定员工id
     * @return 返回删除结果
     * @author wr1sw
     */
    public Integer delEmpById(Integer employeeId) {
        return employeeMapper.delEmpById(employeeId);
    }
}
