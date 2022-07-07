package com.lyd.management.model;

public class Employee {
    private Integer employeeId;
    private String userName;
    private String phone;
    private String email;
    private Integer status;
    private String password;

    public Employee() {
    }

    public Employee(Integer employeeId, String userName, String phone, String email, Integer status, String password) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.password = password;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
