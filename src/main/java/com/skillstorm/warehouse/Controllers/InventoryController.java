package com.skillstorm.warehouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.warehouse.Model.Inventory;
import com.skillstorm.warehouse.Model.Warehouse;
import com.skillstorm.warehouse.Services.InventorySercices;

@RestController
@RequestMapping("/inventories")
@CrossOrigin("*")
public class InventoryController {
    @Autowired
    InventorySercices inventorySercices;

    @GetMapping
    public ResponseEntity<List<Inventory>> findAllInventory(){
        List<Inventory> inventory = inventorySercices.findAllInventories();
        return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<List<Inventory>> findWarehouseInventory(@PathVariable int id){
        List<Inventory> inventory = inventorySercices.findWarehouseInventory(id);
        return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

    @PostMapping("/inventory")
    public ResponseEntity<Inventory> createInventoryItem(@RequestBody Inventory inventory){
        Inventory newInventory = inventorySercices.saveInventory(inventory);
        return new ResponseEntity<Inventory>(newInventory, HttpStatus.OK);
    }

    @PutMapping("/inventory")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory){
        Inventory newInventory = inventorySercices.saveInventory(inventory);
        return new ResponseEntity<Inventory>(newInventory, HttpStatus.OK);
    }
    @PutMapping("/inventory/updateItem")
    public ResponseEntity<Integer> updateInvnentoryItem(@RequestBody Inventory inventory, @RequestParam String newItemName){
        int updated = inventorySercices.updateInventoryItem(inventory, newItemName);
        return new ResponseEntity<Integer>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/inventory")
    public ResponseEntity<Inventory> deleteWarehouse(@RequestBody Inventory inventory){
        inventorySercices.deleteInventory(inventory);
        return ResponseEntity.noContent().build();
    }
}
