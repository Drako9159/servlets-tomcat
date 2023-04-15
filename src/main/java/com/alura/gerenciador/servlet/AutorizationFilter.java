package com.alura.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = "/home")
public class AutorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Autorization filter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String paramAction = req.getParameter("action");

        HttpSession sesion = req.getSession();
        Boolean isUserLogged = (sesion.getAttribute("loginUser") == null);
        Boolean isActionProtected = !(paramAction.equals("login") || paramAction.equals("form-login"));

        if (isUserLogged && isActionProtected) {
            resp.sendRedirect("home?action=form-login");

        }

        filterChain.doFilter(req, resp);

    }
}
