package com.alura.gerenciador.servlet;

import com.alura.gerenciador.actions.*;
import jakarta.servlet.RequestDispatcher;
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

        // Reflexión
        /*
        String nameClass = "com.alura.gerenciador.actions" + paramAction;
        try {
            Class clase = Class.forName(nameClass);
            Action action = (Action) clase.newInstance();
            String name = action.exect(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e){
            throw new ServletException(e);
        }*/


        String name = null;
        if(paramAction.equals("list-companys")){
            ListCompany listCompany = new ListCompany();
            name = listCompany.exect(req, resp);

        } else if (paramAction.equals("show-company")){
            ShowCompany showCompany = new ShowCompany();
            name = showCompany.exect(req, resp);

        } else if (paramAction.equals("delete-company")){
            DeleteCompany deleteCompany = new DeleteCompany();
            name = deleteCompany.exect(req, resp);

        } else if (paramAction.equals("update-company")){
            UpdateCompany updateCompany = new UpdateCompany();
            name = updateCompany.exect(req, resp);

        } else if (paramAction.equals("form-new-company")){
            FormNewCompany formNewCompany = new FormNewCompany();
            name = formNewCompany.exect(req, resp);

        } else if (paramAction.equals("create-company")){
            CreateCompany createCompany = new CreateCompany();
            name = createCompany.exect(req, resp);

        } else if (paramAction.equals("login")){
            Login login = new Login();
            name = login.exect(req, resp);

        } else if (paramAction.equals("form-login")){
            FormLogin formLogin = new FormLogin();
            name = formLogin.exect(req, resp);
        }


        String[] typeDirectiom = name.split(":");
        if(typeDirectiom[0].equals("forward")){
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/"+typeDirectiom[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(typeDirectiom[1]);
        }





    }



}
