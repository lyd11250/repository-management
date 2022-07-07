package com.lyd.management.service.impl;

import com.lyd.management.dao.SupplierMapper;
import com.lyd.management.model.Supplier;
import com.lyd.management.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getSupplierListService() {
        List<Supplier> supplierList = supplierMapper.findSupplierList();
        return supplierList;
    }

    @Override
    public Boolean removeSupplierService(int spId) {
        boolean result = supplierMapper.deleteSupplierById(spId);
        return result;
    }

    @Override
    public boolean addSupplierService(Supplier supplier) {
        boolean result = supplierMapper.saveSupplier(supplier);
        return result;
    }

    @Override
    public boolean editSupplierService(Supplier supplier) {
        boolean result = supplierMapper.updateSupplier(supplier);
        return result;
    }
}
