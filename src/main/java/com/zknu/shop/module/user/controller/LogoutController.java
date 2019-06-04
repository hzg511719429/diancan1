package com.zknu.shop.module.user.controller;

import com.zknu.shop.common.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            request.getSession().removeAttribute("user");
        }
        return "redirect:index";
    }
}
