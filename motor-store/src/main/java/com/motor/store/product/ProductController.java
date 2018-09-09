package com.motor.store.product;

import com.google.gson.Gson;
import com.motor.common.dictionaries.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private Gson gson;
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("product/index");
        return mav;
    }

    @RequestMapping("/product/getProducts")
    @ResponseBody
    public String getProducts() {
        return gson.toJson(productService.getProducts());
    }
}
