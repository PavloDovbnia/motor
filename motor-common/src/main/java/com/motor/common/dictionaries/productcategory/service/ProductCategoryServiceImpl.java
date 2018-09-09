package com.motor.common.dictionaries.productcategory.service;

import com.motor.common.dictionaries.productcategory.ProductCategory;
import com.motor.common.dictionaries.productcategory.dao.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductsCategories() {
        return productCategoryDao.getProductsCategories();
    }
}
