package com.imooc.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.jnlp.FileContents;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: 请求执行之后过滤器
 * @author: lvyong
 * @date: 2019-10-24
 * @time: 1:34 下午
 * @version: 1.0
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 当前过滤器需要最后执行
     * zuul 组件默认的 response filter 的 order 是 1000（因为zuul的FilterConstants.SEND_RESPONSE_FILTER_ORDER
     * 常量就是1000），所以我们的 response 过滤器的 order要在 FilterConstants.SEND_RESPONSE_FILTER_ORDER 之前，否则不起作用。
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Long startTime = (Long) context.get("startTime");
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;

        log.info("uri: " + uri + ", duration: " + duration / 100 + "ms");

        return null;
    }
}
