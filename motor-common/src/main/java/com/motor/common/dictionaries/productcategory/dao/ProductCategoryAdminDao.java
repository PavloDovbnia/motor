package com.motor.common.dictionaries.productcategory.dao;

import com.motor.common.dictionaries.productcategory.ProductCategory;

public interface ProductCategoryAdminDao {

    int addProductCategory(ProductCategory productCategory);

    void editProductCategory(ProductCategory productCategory);
}
