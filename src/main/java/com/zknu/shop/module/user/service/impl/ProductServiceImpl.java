package com.zknu.shop.module.user.service.impl;

import com.zknu.shop.common.mapper.ProductMapper;
import com.zknu.shop.common.mapper.ProductimgMapper;
import com.zknu.shop.common.pojo.Product;
import com.zknu.shop.common.pojo.Productimg;
import com.zknu.shop.common.pojo.ProductimgExample;
import com.zknu.shop.module.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductimgMapper productimgMapper;

    @Override
    public Product getProductById(long id) {
        //根据id查询商品
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public List<Productimg> getProductimgList(long id) {
        ProductimgExample example2 = new ProductimgExample();
        ProductimgExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andProductIdEqualTo(id);
        List<Productimg> productimgList = productimgMapper.selectByExample(example2);
        return productimgList;
    }

    @Override
    public void updateDeleteImg(long productImgId) {
        productimgMapper.deleteByPrimaryKey(productImgId);
    }
}
