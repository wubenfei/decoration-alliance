package com.ours.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Component
public class SessionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取容器
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpSession session = ctx.getRequest().getSession();
        //Base64加密代码
        String SESSION= Base64.getEncoder().encodeToString(session.getId().getBytes());
        //将str加入请求头中
        ctx.addZuulRequestHeader("Cookie", "SESSION="+SESSION);
        System.out.println("网关中存入的session："+session.getId());
        return null;
    }
}
