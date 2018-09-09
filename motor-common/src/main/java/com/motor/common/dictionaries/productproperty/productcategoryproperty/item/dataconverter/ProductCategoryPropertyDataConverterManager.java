package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductCategoryPropertyDataConverterManager {

    private Map<ProductCategoryPropertyDataType, ProductCategoryPropertyDataConverter> dataConverters = new HashMap<>();

    @Autowired
    public void setDataConverters(List<ProductCategoryPropertyDataConverter> dataConverters) {
        for(ProductCategoryPropertyDataConverter dataConverter : dataConverters) {
            this.dataConverters.put(dataConverter.getDataType(), dataConverter);
        }
    }

    public <T> convertData(ProductCategoryPropertyDataType dataType, String data){
        ProductCategoryPropertyDataConverter dataConverter = dataConverters.get(dataType);
        return dataConverter.convertData(data);
    }
}
