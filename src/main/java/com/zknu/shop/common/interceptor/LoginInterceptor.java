package com.zknu.shop.common.interceptor;


import com.zknu.shop.common.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2016/12/21
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String url = request.getRequestURI().toString();
//        if (url.startsWith(request.getContextPath()+"/admin")){ //后台管理平台
//            EcsAdminUser admin = (EcsAdminUser) request.getSession().getAttribute("admin");
//            if(null==admin){
//                response.sendRedirect(request.getContextPath()+"/admin/login");
//                return  false;
//            }
//        }
        //获取请求的uri
        String uri = request.getRequestURI();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
