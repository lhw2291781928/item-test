package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JavaLi
 * @description: 自定义过滤器打印执行时间
 * @date 2020/11/22 15:56:52
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //在请求之后
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {

        //在响应发送之前执行  相当于在请求之后，响应发送之前执行该过滤器
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {


        RequestContext ctx = RequestContext.getCurrentContext();
        Long startTime = (Long) ctx.get("startTime");

        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();

        long totalTime = System.currentTimeMillis() - startTime;
        log.info("uri:{},totalTime{}",uri,totalTime/100);

        return null;
    }
}
