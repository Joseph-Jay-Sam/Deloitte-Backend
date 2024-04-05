package com.skillstorm.warehouse.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.warehouse.Model.Inventory;
import com.skillstorm.warehouse.Model.Warehouse;
import com.skillstorm.warehouse.Repositories.InventoryRepository;

@Service
public class InventorySercices {

    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> findWarehouseInventory(int warehouseId){
        return inventoryRepository.findByWarehouseId(warehouseId);
        
    }

    public List<Inventory> findAllInventories(){
        return inventoryRepository.findAll();
    }

    public Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public int updateInventoryItem(Inventory inventory, String newInventoryName){
        return inventoryRepository.updateInventoryName(inventory.getId(), newInventoryName);
    }

    public void deleteInventory(Inventory inventory){
        inventoryRepository.delete(inventory);
    }
    
}
