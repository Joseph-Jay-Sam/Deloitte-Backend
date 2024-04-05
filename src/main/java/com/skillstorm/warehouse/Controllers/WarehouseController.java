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

import com.skillstorm.warehouse.Model.Warehouse;
import com.skillstorm.warehouse.Services.WarehouseServices;

@RestController
@RequestMapping("/warehouses")
@CrossOrigin("*")
public class WarehouseController {
    
    @Autowired
    WarehouseServices warehouseService;

    @GetMapping //Get Request to handle returning an unconditional list of all warehouses
    public ResponseEntity<List<Warehouse>> findAllWarehouses(){
        List<Warehouse> warehouses = warehouseService.findAllWarehouses();

        return new ResponseEntity<List<Warehouse>>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/warehouse/{id}") //get request to handle returning a single warehouse that matches an ID
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable int id){
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        return new ResponseEntity<Warehouse>(warehouse, HttpStatus.OK);
    }

    @PostMapping("/warehouse") // Post request to handle creating a brand new Warehouse
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse){
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }
    @PutMapping("/warehouse") // Put request to handle updating an already existing warehouse
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse){
        Warehouse newWarehouse = warehouseService.saveWarehouse(warehouse);
        return new ResponseEntity<Warehouse>(newWarehouse, HttpStatus.OK);
    }
    @PutMapping("/warehouse/updateAddress") // Put request to handle updating a warehouse given a new address within the url parameters
    public ResponseEntity<Integer> updateWarehouseAddress(@RequestBody Warehouse warehouse, @RequestParam String newAddress){
        int updated = warehouseService.updateWarehouseAddress(warehouse, newAddress);
        return new ResponseEntity<Integer>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/warehouse") // Delete request to handle deleting BOTH a warehouse AND its inventory
    public ResponseEntity<Warehouse> deleteWarehouse(@RequestBody Warehouse warehouse){
        warehouseService.deleteWarehouse(warehouse);
        return ResponseEntity.noContent().build();
    }
}
