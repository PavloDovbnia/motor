package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryPropertyBooleanConverter implements ProductCategoryPropertyDataConverter<Boolean> {

    @Override
    public ProductCategoryPropertyDataType getDataType() {
        return ProductCategoryPropertyDataType.BOOLEAN;
    }

    @Override
    public Boolean convertData(String data) {
        return "1".equals(data);
    }
}
