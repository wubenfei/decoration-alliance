package com.ours.department.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "total", urlPatterns = "/*")
public class RequestHeadFilter implements Filter{

    private ArrayList<String> allowOrigin = new ArrayList<>();

    public void TotalFilter() {
        allowOrigin.add("http://127.0.0.1:8083");
        allowOrigin.add("http://localhost:8083");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String origin = ((HttpServletRequest) servletRequest).getHeader("Origin");
        // INFO: DCTANT: 2019/9/19 设置允许的跨域请求源
        if (allowOrigin.contains(origin)) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        } else {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8083");
        }
        // INFO: DCTANT: 2019/9/19 设置允许的跨域请求头
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With, userId, token, x-requested-with, XMLHttpRequest, Accept");
        // INFO: DCTANT: 2019/9/19 设置允许的跨域请求方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // INFO: DCTANT: 2019/9/19 设置允许跨域请求的最长时间，这里设置了30天，就为了尽量延长允许时间，
        //  时间过短会导致经常在请求前先发送一个Option请求，用于获取服务端允许哪些跨域访问类型，导致资源浪费。
        httpServletResponse.setHeader("Access-Control-Max-Age", "2592000");
        // INFO: DCTANT: 2019/9/19 这个非常重要！设置允许携带证书信息，包括Session和Cookie等等
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        // INFO: DCTANT: 2019/9/19 设置请求类型为json请求
        httpServletResponse.setContentType("application/json;charset=utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
