package com.lyd.management.service;

import com.lyd.management.model.Supplier;
import java.util.List;

public interface SupplierService {
    List<Supplier> getSupplierListService();
    Boolean removeSupplierService(int spId);
    boolean addSupplierService(Supplier supplier);
    boolean editSupplierService(Supplier supplier);
}
