package com.alura.gerenciador.servlet;

import com.alura.gerenciador.actions.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class ControllerPrimary extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAction = req.getParameter("action");
        if(paramAction.equals("list-companys")){
            ListCompany listCompany = new ListCompany();
            listCompany.exect(req, resp);

        } else if (paramAction.equals("show-company")){
            ShowCompany showCompany = new ShowCompany();
            showCompany.exect(req, resp);

        } else if (paramAction.equals("delete-company")){
            DeleteCompany deleteCompany = new DeleteCompany();
            deleteCompany.exect(req, resp);

        } else if (paramAction.equals("update-company")){
            UpdateCompany updateCompany = new UpdateCompany();
            updateCompany.exect(req, resp);

        } else if (paramAction.equals("create-company")){
            CreateCompany createCompany = new CreateCompany();
            createCompany.exect(req, resp);
        }

    }



}
