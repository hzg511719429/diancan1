package com.zknu.shop.module.user.service;

import com.zknu.shop.common.pojo.Product;
import com.zknu.shop.common.pojo.Productimg;
import com.zknu.shop.common.util.ShopResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {

    /**
     * 根据商品id获取商品
     * @param id
     * @return
     */
    Product getProductById(long id);

    /**
     * 根据商品id获取商品图片
     * @param id
     * @return
     */
    List<Productimg> getProductimgList(long id);

    /**
     * 根据商品图片id删除商品图片
     * @param productImgId
     */
    void updateDeleteImg(long productImgId);
}
