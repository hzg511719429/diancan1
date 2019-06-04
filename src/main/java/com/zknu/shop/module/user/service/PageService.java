package com.zknu.shop.module.user.service;

import com.zknu.shop.common.util.PageResult;

/**
 * @author guang
 */
public interface PageService {

    PageResult getProductList(int page, int row, int status, double min, double max, String word);
}
