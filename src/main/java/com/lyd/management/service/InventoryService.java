package com.lyd.management.service;

import com.lyd.management.model.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> selectAllService();

    boolean addInventoryService(Inventory inventory);

    boolean editInventoryService(Inventory inventory);

    boolean inAndOutService(Inventory inventory);

    boolean putInService(Inventory inventory);

    boolean putOutService(Inventory inventory);

}
