package com.skillstorm.warehouse.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="warehouses")
public class Warehouse {
    /*
     *  The fields represented in this class are that of the fields of the table this object represents
     * 
     * 
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="warehouseaddress")
    private String warehouseAddress;

    @Column
    private int capacity;

    public Warehouse() {
    }

    public Warehouse(int id, String warehouseAddress, int capacity) {
        this.id = id;
        this.warehouseAddress = warehouseAddress;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((warehouseAddress == null) ? 0 : warehouseAddress.hashCode());
        result = prime * result + capacity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Warehouse other = (Warehouse) obj;
        if (id != other.id)
            return false;
        if (warehouseAddress == null) {
            if (other.warehouseAddress != null)
                return false;
        } else if (!warehouseAddress.equals(other.warehouseAddress))
            return false;
        if (capacity != other.capacity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Warehouse [id=" + id + ", warehouseAddress=" + warehouseAddress + ", capacity=" + capacity + "]";
    }

    
}
