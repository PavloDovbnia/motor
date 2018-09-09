package com.motor.common.dictionaries.productproperty.productcategoryproperty;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.item.ProductCategoryPropertyItem;

import java.io.Serializable;

public class ProductCategoryProperty implements Serializable {

    private static final long SerialVersionUID = 1L;

    private int id;
    private int productCategoryId;
    private ProductCategoryPropertyItem property;

    public ProductCategoryProperty() {
    }

    public ProductCategoryProperty(int id, int productCategoryId, ProductCategoryPropertyItem property) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.property = property;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public ProductCategoryPropertyItem getProperty() {
        return property;
    }

    public void setProperty(ProductCategoryPropertyItem property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryProperty that = (ProductCategoryProperty) o;

        if (productCategoryId != that.productCategoryId) return false;
        return property.equals(that.property);
    }

    @Override
    public int hashCode() {
        int result = productCategoryId;
        result = 31 * result + property.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductCategoryProperty{" +
                "id=" + id +
                ", productCategoryId=" + productCategoryId +
                ", property=" + property +
                '}';
    }
}
