package com.jianla.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * 通用异常处理
 * 应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行
 * <p>
 * 配置在spring-mvc.xml中，没有跟controller一起扫描到
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({Exception.class})
    public ModelAndView exception(HttpServletRequest request, Exception e) {
        logger.error("发生未知异常", e);
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
