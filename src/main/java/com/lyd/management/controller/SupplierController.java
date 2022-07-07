package com.lyd.management.controller;

import com.lyd.management.model.Supplier;
import com.lyd.management.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "supplier")
public class SupplierController {
    @Autowired
    SupplierServiceImpl supplierService;

    @GetMapping(value = "/list")
    public List<Supplier> selectSupplierList(){
        List<Supplier> supplierList = supplierService.getSupplierListService();
        return supplierList;
    }

    @PostMapping(value = "/delete")
    public boolean deleteSupplier(String spId){
        System.out.println(spId);
        boolean result = supplierService.removeSupplierService(Integer.parseInt(spId));
        return result;
    }
    @RequestMapping("/new")
    public boolean newSupplier(Supplier supplier){
        System.out.println(supplier);
        //调用service层的方法来处理请求逻辑
        boolean result = supplierService.addSupplierService(supplier);
        return result;
    }

    @RequestMapping("/edit")
    public boolean editSupplier(Supplier supplier){

        boolean result = supplierService.editSupplierService(supplier);
        return result;
    }
}
