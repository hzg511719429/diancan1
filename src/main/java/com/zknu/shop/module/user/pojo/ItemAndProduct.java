package com.zknu.shop.module.user.pojo;

import com.zknu.shop.common.pojo.Item;

public class ItemAndProduct extends Item {

    private String productName;
    private double productPrice;

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
}
