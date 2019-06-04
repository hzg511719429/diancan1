package com.zknu.shop.common.exception;

import com.zknu.shop.common.util.ShopResult;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Description: 一个支持 json 和jsp两种错误视图的 全局异常处理器
 * @CreateDate: 2017/5/25
 */
public class ExceptionResolverCustom implements HandlerExceptionResolver {
    //将错误信息解析成json返回客户端
    private HttpMessageConverter<ShopResult> jsonmessageConverter;

    /**
     * 异常发生执行的方法，ex记录了系统执行过程中的异常信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        //输出异常信息
        ex.printStackTrace();
        if (ex instanceof MaxUploadSizeExceededException) {//文件上传错误
            //返回类型为json方法的异常处理
            try {
                Exception exceptionResultInfo=new ExceptionResultInfo(ShopResult.build(500,"文件过大"));
                return handleResponseBody(exceptionResultInfo, request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //请求的action
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handlerMethod==null){
            return null;
        }
        //获取action执行的方法
        Method method = handlerMethod.getMethod();

        if (method == null) {
            return null;
        }
        //使用AnnotationUtils工具类，找action方法上边注解ResponseBody
        ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method,
                ResponseBody.class);
        //如果action返回方法的类型是json
        if (responseBodyAnn != null) {
            try {
                //返回类型为json方法的异常处理
                return handleResponseBody(ex, request, response);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //这里表示action的方法返回的不是json
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");//走视图解析器
        ExceptionResultInfo resultInfo = null;
        if (ex instanceof ExceptionResultInfo) {
            //resultInfo = ((ExcepResultInfo) ex).getResultInfo();
            resultInfo = (ExceptionResultInfo) ex;
        } else {
            //判断抛出的异常是否是系统特定的异常类，如果不是则需要构造成系统特定的异常类
            //构造resultInfo

            resultInfo = new ExceptionResultInfo(ShopResult.build(500, "系统发生异常"));
        }
        //将异常信息内容传到页面
        modelAndView.addObject("message", resultInfo.getMessage());


        return modelAndView;
    }

    //自定义的处理action返回类型为json的异常处理方法
    private ModelAndView handleResponseBody(Exception ex,
                                            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ResultInfo value =  ((ExcepResultInfo) ex).getResultInfo();
        //判断抛出的异常是否是系统特定的异常类
        if (!(ex instanceof ExceptionResultInfo)) {
            //封装成系统自定义的异常
            ex = new ExceptionResultInfo(ShopResult.build(500, "系统发生异常"));
        }
        //转化成系统自定义的异常
        ExceptionResultInfo value = (ExceptionResultInfo) ex;
        //创建http输出对象
        response.setCharacterEncoding("utf-8");//解决中文乱码
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(
                response);
        //将异常信息输出成json
        jsonmessageConverter.write(value.getShopResult(), MediaType.APPLICATION_JSON, outputMessage);
        return new ModelAndView();
    }

    public HttpMessageConverter<ShopResult> getJsonmessageConverter() {
        return jsonmessageConverter;
    }

    public void setJsonmessageConverter(HttpMessageConverter<ShopResult> jsonmessageConverter) {
        this.jsonmessageConverter = jsonmessageConverter;
    }
}
