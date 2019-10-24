package com.imooc.ad.advice;

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 在响应返回之前做一些自定义的处理，包装为统一的响应返回
 * @author: lvyong
 * @date: 2019-10-24
 * @time: 2:01 下午
 * @version: 1.0
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行出来
     * true 需要  false  不需要
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        //如果在类上标识了IgnoreResponseAdvice注解，不处理
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        //如果在方法上标识IgnoreResponseAdvice注解，不处理
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    /**
     * 处理为统一的响应返回
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CommonResponse<Object> response = new CommonResponse<>(0,"");
        //如果o 是null ，则不需要设置data
        if ( o == null) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse) o;
        } else {
            response.setData(o);
        }
        return response;
    }
}
