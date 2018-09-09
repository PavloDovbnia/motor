package com.motor.common.dictionaries.brand.dao;

import com.motor.common.dictionaries.brand.Brand;
import com.motor.common.helpers.SqlQueriesXmlFileReader;
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
public class BrandDaoImpl extends SqlQueriesXmlFileReader implements BrandDao, BrandAdminDao {

    private static final String FILE_NAME = "/com/motor/common/dictionaries/brand/brand-sql-queries.xml";
    private static final String GET_BRANDS = "getBrands";
    private static final String ADD_BRAND = "addBrand";
    private static final String EDIT_BRAND = "editBrand";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public BrandDaoImpl() {
        super(FILE_NAME);
    }

    @Override
    public List<Brand> getBrands() {
        return jdbcTemplate.query(GET_BRANDS, new BrandRowMapper());
    }

    @Override
    public int addBrand(Brand brand) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", brand.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(ADD_BRAND, namedParameters);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void editBrand(Brand brand) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", brand.getId())
                .addValue("name", brand.getName());
        jdbcTemplate.update(EDIT_BRAND, namedParameters);
    }

    private static class BrandRowMapper implements RowMapper<Brand> {
        @Nullable
        @Override
        public Brand mapRow(ResultSet rs, int i) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            return new Brand(id, name);
        }
    }
}
