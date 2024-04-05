package com.skillstorm.warehouse.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.warehouse.Model.Inventory;
import com.skillstorm.warehouse.Model.Warehouse;
import com.skillstorm.warehouse.Repositories.WarehouseRepository;

@Service
public class WarehouseServices {
    
    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    InventorySercices inventorySercices;

    public List<Warehouse> findAllWarehouses(){ //unconditional find all
        return warehouseRepository.findAll();
    }

    public Warehouse findWarehouseById(int id){ //find specific warehouse
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);

        if(warehouse.isPresent()){
            return warehouse.get();
        }
        else{
            return null;
        }
    }
    public Warehouse saveWarehouse(Warehouse warehouse){ //save warehouse in database
        return warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Warehouse warehouse){ //When deleting a warehouse, FIRST, delete all inventory items within the warehouse, then delete the warehouse
        List<Inventory> warehouseInventory = inventorySercices.findWarehouseInventory(warehouse.getId());
        for(Inventory inventory : warehouseInventory){
            inventorySercices.deleteInventory(inventory);
        }
        warehouseRepository.delete(warehouse);

    }

    public int updateWarehouseAddress(Warehouse warehouse, String newWarehouseAddress){
        return warehouseRepository.updateWarehouseAddress(warehouse.getId(), newWarehouseAddress);
    }

    
}
