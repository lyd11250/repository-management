package com.lyd.management.controller;

import com.lyd.management.model.Inventory;
import com.lyd.management.service.GoodService;
import com.lyd.management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value="inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/list")
    public List<Inventory> selectAll(){
        return inventoryService.selectAllService();
    }

    @RequestMapping(value = "/add")
    public boolean addInventory(Inventory inventory) {
        return inventoryService.addInventoryService(inventory);
    }

    @RequestMapping(value = "/edit")
    public boolean editInventory(Inventory inventory) {
        return inventoryService.editInventoryService(inventory);
    }

    @RequestMapping(value = "/inAndOut")
    public boolean inAndOut(Inventory inventory) {
        return inventoryService.inAndOutService(inventory);
    }

    @RequestMapping(value = "/putIn")
    public boolean putIn(Inventory inventory) {
        return inventoryService.putInService(inventory);
    }

    @RequestMapping(value = "/putOut")
    public boolean putOut(Inventory inventory) {
        return inventoryService.putOutService(inventory);
    }

}
