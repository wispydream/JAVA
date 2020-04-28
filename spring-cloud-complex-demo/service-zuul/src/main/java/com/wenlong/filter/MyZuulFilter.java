package com.wenlong.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 11:39 2018/10/24
 * @ Description：${description}
 * @ Modified By：
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    @Override
    public String filterType() {
        // 请求之前拦截
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 开启过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("token");
        if (accessToken != null) {
            return null;
        }

        log.warn("token is empty");
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(401);
        try {
            requestContext.getResponse().getWriter().write("token is empty");
        } catch (Exception e) {
        }
        return null;
    }
}
