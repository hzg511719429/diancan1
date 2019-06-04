package com.zknu.shop.common.exception;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/5/25
 */

import com.zknu.shop.common.util.ShopResult;
import com.zknu.shop.common.util.ShopResult;

/**
 * 自定义系统异常类
 *
 * @author mrt
 */
public class ExceptionResultInfo extends Exception {

    /**
     * 系统提示信息
     */
    private ShopResult shopResult;

    public ExceptionResultInfo(ShopResult shopResult) {
        super(shopResult.getMsg());
        this.shopResult = shopResult;
    }



    //get方法在转json时使用


    public ShopResult getShopResult() {
        return shopResult;
    }

    public void setShopResult(ShopResult shopResult) {
        this.shopResult = shopResult;
    }
}