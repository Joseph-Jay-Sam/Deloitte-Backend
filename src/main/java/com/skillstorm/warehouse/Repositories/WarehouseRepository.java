package com.skillstorm.warehouse.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.warehouse.Model.Warehouse;

import jakarta.transaction.Transactional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    @Query("update Warehouse w set w.warehouseAddress = :newAddress where id = :warehouse_id")
    @Modifying
    @Transactional
    public int updateWarehouseAddress(@Param("warehouse_id") int id, @Param("newAddress") String newAddress);
} 
