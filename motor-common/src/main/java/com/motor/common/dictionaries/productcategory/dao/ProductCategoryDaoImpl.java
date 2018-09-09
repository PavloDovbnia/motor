package com.motor.common.dictionaries.productcategory.dao;

import com.motor.common.helpers.SqlQueriesXmlFileReader;
import com.motor.common.dictionaries.productcategory.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductCategoryDaoImpl extends SqlQueriesXmlFileReader implements ProductCategoryDao, ProductCategoryAdminDao {

    private static final String FILE_NAME = "/com/motor/common/dictionaries/productcategory/productcategory-sql-queries.xml";
    private static final String GET_PRODUCTS_CATEGORIES = "getProductsCategories";
    private static final String ADD_PRODUCT_CATEGORY = "addProductCategory";
    private static final String EDIT_PRODUCT_CATEGORY = "editProductCategory";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public ProductCategoryDaoImpl() {
        super(FILE_NAME);
    }

    @Override
    public List<ProductCategory> getProductsCategories() {
        return jdbcTemplate.query(getSqlQuery(GET_PRODUCTS_CATEGORIES), new ProductCategoryRowMapper());
    }

    @Override
    public int addProductCategory(ProductCategory productCategory) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", productCategory.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(getSqlQuery(ADD_PRODUCT_CATEGORY), namedParameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void editProductCategory(ProductCategory productCategory) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", productCategory.getId())
                .addValue("name", productCategory.getName());
        jdbcTemplate.update(getSqlQuery(EDIT_PRODUCT_CATEGORY), namedParameters);
    }

    private static class ProductCategoryRowMapper implements RowMapper<ProductCategory> {
        @Nullable
        @Override
        public ProductCategory mapRow(ResultSet rs, int i) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            return new ProductCategory(id, name);
        }
    }
}
