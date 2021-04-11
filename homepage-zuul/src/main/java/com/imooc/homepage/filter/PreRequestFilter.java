package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author JavaLi
 * @description: 自定义过滤器(存储客户端发起请求的时间戳)
 * @date 2020/11/22 15:48:41
 */
@Component
public class PreRequestFilter extends ZuulFilter {


    /**
     * 指定过滤器的类型
     * @return
     */
    @Override
    public String filterType() {

        //请求最开始的时候
        return FilterConstants.PRE_TYPE;
    }


    /**
     * 过滤器的执行顺序，数值越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * 是否启动过滤器,里面可以根据实际业务情况，加业务判断来决定是否启动
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //RequestContext  用于在过滤器之间传递消息 ,属于线程私有,由ConcurrentHashMap实现
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());

        return null;
    }
}
