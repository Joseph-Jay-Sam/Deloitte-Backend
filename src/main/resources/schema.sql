drop table if EXISTS warehouses;
drop table if exists inventory;

CREATE TABLE warehouses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    warehouseAddress VARCHAR(100) NOT NULL,
	capacity INT
);

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    warehouse_id INT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    quantity INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouses(id)
);