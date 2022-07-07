package com.lyd.management.model;

import lombok.Data;

@Data
public class Supplier {
    private Integer spId;
    private String spName;
    private String spCon;
    private String spAdd;
    private String spPhone;
    private String spGoods;

    public Integer getSpId() {
        return spId;
    }

    public String getSpName() {
        return spName;
    }

    public String getSpCon() {
        return spCon;
    }

    public String getSpAdd() {
        return spAdd;
    }

    public String getSpPhone() {
        return spPhone;
    }

    public String getSpGoods() {
        return spGoods;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public void setSpCon(String spCon) {
        this.spCon = spCon;
    }

    public void setSpAdd(String spAdd) {
        this.spAdd = spAdd;
    }

    public void setSpPhone(String spPhone) {
        this.spPhone = spPhone;
    }

    public void setSpGoods(String spGoods) {
        this.spGoods = spGoods;
    }
}
