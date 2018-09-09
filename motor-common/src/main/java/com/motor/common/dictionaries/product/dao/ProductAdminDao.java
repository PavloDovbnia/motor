package com.motor.common.dictionaries.product.dao;

import com.motor.common.dictionaries.product.Product;

public interface ProductAdminDao extends ProductDao {

    int addProduct(Product product);

    void editProduct(Product product);
}
