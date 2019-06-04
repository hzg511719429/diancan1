package com.zknu.shop.module.user.service;

import com.zknu.shop.common.pojo.User;

public interface RegistService {

    /**
     * 检查用户名是否已经存在
     * @param userEmail 根据用户名，即邮箱
     * @return
     */
    User getUserByEmail(String userEmail);

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 更改用户
     * @param user
     */
    void updateUser(User user);
}
