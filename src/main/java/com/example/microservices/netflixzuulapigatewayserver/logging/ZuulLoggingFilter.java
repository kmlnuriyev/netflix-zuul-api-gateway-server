package com.example.microservices.netflixzuulapigatewayserver.logging;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        // before ("pre") or after ("post") request executed or in error ("error") case
        return "pre";
    }

    @Override
    public int filterOrder() {
        // we may have multiple filters
        // we are setting the priority among of them
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // execute filter or not
        // we want to execute filter for every request
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());

        return null;
    }
}
