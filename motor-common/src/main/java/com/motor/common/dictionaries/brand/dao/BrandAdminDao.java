package com.motor.common.dictionaries.brand.dao;

import com.motor.common.dictionaries.brand.Brand;

public interface BrandAdminDao {

    int addBrand(Brand brand);

    void editBrand(Brand brand);
}
