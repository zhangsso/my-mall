package com.zhangs.zullservice.filters;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Description:限流拦截
 * @Author: zhangs
 * @Date: 16:48 2019/7/10
 */
public class TpsLimitFilter extends ZuulFilter {

    //每秒产生1000个令牌,每秒刷新一次令牌桶为1000
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1000);


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //数字越小，越先执行
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        //tryAcquire方法尝试消费令牌桶中的令牌，消费到返回true，否则false。。如果消费不到说明请求人数太多
        if(!RATE_LIMITER.tryAcquire()){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }
}
