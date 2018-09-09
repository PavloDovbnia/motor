package com.motor.common.dictionaries.productproperty.productcategoryproperty.item;

import java.io.Serializable;

public class ProductCategoryPropertyItem implements Serializable {

    private static final long SerialVersionUID = 1L;

    private int id;
    private String name;
    private ProductCategoryPropertyDataType dataType;

    public ProductCategoryPropertyItem() {
    }

    public ProductCategoryPropertyItem(int id, String name, ProductCategoryPropertyDataType dataType) {
        this.id = id;
        this.name = name;
        this.dataType = dataType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryPropertyDataType getDataType() {
        return dataType;
    }

    public void setDataType(ProductCategoryPropertyDataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryPropertyItem that = (ProductCategoryPropertyItem) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "ProductCategoryPropertyItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataType=" + dataType +
                '}';
    }
}
