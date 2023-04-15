package com.alura.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/home")
public class MonitoringFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Monitoring filter");

        long antes = System.currentTimeMillis();

        // ejecution controller
        filterChain.doFilter(servletRequest, servletResponse);

        long despues = System.currentTimeMillis();
        String action = servletRequest.getParameter("action");
        System.out.println("Tiempo de ejecucion de action: "+action+" -> "+(despues-antes));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
