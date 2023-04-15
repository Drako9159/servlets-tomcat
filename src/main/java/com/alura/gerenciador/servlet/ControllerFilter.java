package com.alura.gerenciador.servlet;

import com.alura.gerenciador.actions.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = "/home")
public class ControllerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Controller filter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String paramAction = req.getParameter("action");

        String name = null;
        if (paramAction.equals("list-companys")) {
            ListCompany listCompany = new ListCompany();
            name = listCompany.exect(req, resp);

        } else if (paramAction.equals("show-company")) {
            ShowCompany showCompany = new ShowCompany();
            name = showCompany.exect(req, resp);

        } else if (paramAction.equals("delete-company")) {
            DeleteCompany deleteCompany = new DeleteCompany();
            name = deleteCompany.exect(req, resp);

        } else if (paramAction.equals("update-company")) {
            UpdateCompany updateCompany = new UpdateCompany();
            name = updateCompany.exect(req, resp);

        } else if (paramAction.equals("form-new-company")) {
            FormNewCompany formNewCompany = new FormNewCompany();
            name = formNewCompany.exect(req, resp);

        } else if (paramAction.equals("create-company")) {
            CreateCompany createCompany = new CreateCompany();
            name = createCompany.exect(req, resp);

        } else if (paramAction.equals("login")) {
            Login login = new Login();
            name = login.exect(req, resp);

        } else if (paramAction.equals("form-login")) {
            FormLogin formLogin = new FormLogin();
            name = formLogin.exect(req, resp);

        } else if (paramAction.equals("logout")) {
            Logout logout = new Logout();
            name = logout.exect(req, resp);
        }


        String[] typeDirectiom = name.split(":");
        if (typeDirectiom[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + typeDirectiom[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(typeDirectiom[1]);
        }
    }
}
