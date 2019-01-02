package com.ald.news.core.config.filter;

import com.ald.news.utils.app.TokenUtils;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xdj on 2017/4/24.
 */
@Order(0)
@WebFilter(filterName = "headerFilter", urlPatterns = {"/*"})
public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HeaderFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest;
        HttpServletResponse httpResponse;

        if (request instanceof HttpServletRequest) {
            httpRequest = (HttpServletRequest) request;
            httpResponse = (HttpServletResponse) response;

            String token = httpRequest.getHeader("X-Access-Token");
            String method = httpRequest.getMethod();

            if (!StringUtils.isEmpty(token) && !StringUtils.equals("/error/token", httpRequest.getRequestURI())) {
                DecodedJWT decodedJWT = TokenUtils.verify(token);
                if (decodedJWT == null) {
//                httpResponse.sendError(401, "授权失败");
                    httpResponse.sendRedirect("/error/token");
                }
            }
//            else if (!TextUtils.equals("GET", method) && !TextUtils.equals("OPTIONS", method)) {
//                // post/upDelete/put 必须传token
//                httpResponse.sendRedirect("error/token");
//            }
            // ReactJS通过Ajax请求时出错 解决跨域
            // http://zjblogs.com/js/Access-Control-Allow-Origin.html
            // http://stackoverflow.com/questions/25727306/request-header-field-access-control-allow-headers-is-not-allowed-by-access-contr
//            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//            httpResponse.setHeader("Access-Control-Allow-Headers", "X-Access-Token,Authorization");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("HeaderFilter 销毁");
    }
}
