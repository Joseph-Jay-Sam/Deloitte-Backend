package com.skillstorm.warehouse.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.warehouse.Model.Inventory;

import jakarta.transaction.Transactional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    // @Query("update Warehouse w set w.warehouseAddress = :newAddress where id = :warehouse_id")
    // @Modifying
    // @Transactional
    // public int updateWarehouseAddress(@Param("warehouse_id") int id, @Param("newAddress") String newAddress);

    List<Inventory> findByWarehouseId(int warehouseId);

    @Query("update Inventory i set i.itemName = :newItemName where id = :inventory_id")
    @Modifying
    @Transactional
    public int updateInventoryName(@Param("inventory_id") int id, @Param("newItemName") String newItemName);
} 