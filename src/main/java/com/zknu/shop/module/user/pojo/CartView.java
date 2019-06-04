package com.zknu.shop.module.user.pojo;

import com.zknu.shop.common.pojo.Car;

public class CartView extends Car {

    private String productName;
    private double productPrice;
    private String productImg;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
