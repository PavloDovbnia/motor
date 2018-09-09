package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;

public interface ProductCategoryPropertyDataConverter<T> {

    ProductCategoryPropertyDataType getDataType();

    T convertData(String data);
}
