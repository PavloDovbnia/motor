package com.motor.common.dictionaries.brand.service;

import com.motor.common.dictionaries.brand.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandService brandService;

    @Override
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }
}
