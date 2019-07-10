package com.zhangs.zullservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Description:登录拦截
 * @Author: zhangs
 * @Date: 17:17 2019/7/10
 */
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //此方法为判断条件，返回true就会执行run方法
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println(request.getRequestURI());

        if ("/apigateway/order/api/v1/order/save".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else if ("/apigateway/order/api/v1/order/list".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else if ("/apigateway/order/api/v1/order/find".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //登录校验逻辑  根据公司情况自定义 JWT
        if (StringUtils.isBlank(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}
