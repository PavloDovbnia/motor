package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryPropertyIntegerConverter implements ProductCategoryPropertyDataConverter<Integer> {

    @Override
    public ProductCategoryPropertyDataType getDataType() {
        return ProductCategoryPropertyDataType.INTEGER;
    }

    @Override
    public Integer convertData(String data) {
        return new Integer(data);
    }
}
