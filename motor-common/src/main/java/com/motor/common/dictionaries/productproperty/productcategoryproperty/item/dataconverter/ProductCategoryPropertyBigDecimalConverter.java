package com.motor.common.dictionaries.productproperty.productcategoryproperty.item.dataconverter;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyDataType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductCategoryPropertyBigDecimalConverter implements ProductCategoryPropertyDataConverter<BigDecimal> {

    @Override
    public ProductCategoryPropertyDataType getDataType() {
        return ProductCategoryPropertyDataType.BIG_DECIMAL;
    }

    @Override
    public BigDecimal convertData(String data) {
        return new BigDecimal(data);
    }
}
