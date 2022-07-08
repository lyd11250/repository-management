package com.lyd.management.service.impl;

import com.lyd.management.dao.InventoryMapper;
import com.lyd.management.model.Inventory;
import com.lyd.management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> selectAllService() {
        return inventoryMapper.selectAll();
    }

    @Override
    public boolean addInventoryService(Inventory inventory) {
        return inventoryMapper.addInventory(inventory);
    }

    @Override
    public boolean editInventoryService(Inventory inventory) {
        return inventoryMapper.editInventory(inventory);
    }

    @Override
    public boolean inAndOutService(Inventory inventory) {
        return inventoryMapper.inAndOut(inventory);
    }

    @Override
    public boolean putInService(Inventory inventory) {
        return inventoryMapper.putIn(inventory);
    }

    @Override
    public boolean putOutService(Inventory inventory) {
        return inventoryMapper.putOut(inventory);
    }
}
