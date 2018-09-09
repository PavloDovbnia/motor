package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryPropertyStringConverter implements ProductCategoryPropertyDataConverter<String> {

    @Override
    public ProductCategoryPropertyDataType getDataType() {
        return ProductCategoryPropertyDataType.STRING;
    }

    @Override
    public String convertData(String data) {
        return data;
    }
}
