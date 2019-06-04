package com.zknu.shop.module.user.controller;

import com.zknu.shop.common.pojo.Product;
import com.zknu.shop.common.pojo.Productimg;
import com.zknu.shop.module.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/productDesc")
    public String productDescription(Model model, Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        List<Productimg> productimgList = productService.getProductimgList(id);
        if (productimgList.size() == 0) {
            Productimg productimg = new Productimg();
            productimg.setImgurl("static/img/defult.jpg");
            productimgList.add(productimg);
            model.addAttribute("productImgList",productimgList);
        } else {
            model.addAttribute("productImgList",productimgList);
        }
        return "productDesc";
    }


}
