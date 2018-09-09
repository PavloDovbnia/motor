package com.motor.common.dictionaries.productproperty;

import com.motor.common.dictionaries.productproperty.productcategoryproperty.ProductCategoryProperty;

import java.io.Serializable;

public class ProductProperty<T> implements Serializable {

    private static final long SerialVersionUID = 1L;

    private int id;
    private int productId;
    private ProductCategoryProperty productCategoryProperty;
    private T value;

    public ProductProperty() {
    }

    public ProductProperty(int id, int productId, ProductCategoryProperty productCategoryProperty, String value) {
        this.id = id;
        this.productId = productId;
        this.productCategoryProperty = productCategoryProperty;
        productCategoryProperty.getProperty().getDataType()
        this.value = value;
    }

    public ProductProperty(int id, int productId, ProductCategoryProperty productCategoryProperty, T value) {
        this.id = id;
        this.productId = productId;
        this.productCategoryProperty = productCategoryProperty;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductCategoryProperty<T> getProductCategoryProperty() {
        return productCategoryProperty;
    }

    public void setProductCategoryProperty(ProductCategoryProperty<T> productCategoryProperty) {
        this.productCategoryProperty = productCategoryProperty;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductProperty<?> that = (ProductProperty<?>) o;

        if (productId != that.productId) return false;
        return productCategoryProperty.equals(that.productCategoryProperty);
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + productCategoryProperty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductProperty{" +
                "id=" + id +
                ", productId=" + productId +
                ", productCategoryProperty=" + productCategoryProperty +
                ", value=" + value +
                '}';
    }
}
