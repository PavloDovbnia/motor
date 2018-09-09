package com.motor.common.dictionaries.product.dao;

import com.motor.common.helpers.SqlQueriesXmlFileReader;
import com.motor.common.dictionaries.product.Product;
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
public class ProductDaoImpl extends SqlQueriesXmlFileReader implements ProductAdminDao, ProductDao {

    private static final String FILE_NAME = "/com/motor/common/product/product-sql-queries.xml";
    private static final String GET_PRODUCTS = "getProducts";
    private static final String ADD_PRODUCT = "addProduct";
    private static final String EDIT_PRODUCT = "editProduct";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public ProductDaoImpl() {
        super(FILE_NAME);
    }

    @Override
    public List<Product> getProducts() {
        return jdbcTemplate.query(getSqlQuery(GET_PRODUCTS), new ProductRowMapper());
    }

    @Override
    public int addProduct(Product product) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", product.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_PRODUCT, namedParameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void editProduct(Product product) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", product.getId())
                .addValue("name", product.getName());
        jdbcTemplate.update(EDIT_PRODUCT, namedParameters);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Nullable
        @Override
        public Product mapRow(ResultSet rs, int i) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            return new Product(id, name);
        }
    }
}
