package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/alter-company")
public class alertCompanyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Company modifiqueted");
        String nameCompany = req.getParameter("name");
        String dateCompany = req.getParameter("fecha");
        String idCompany = req.getParameter("id");
        Integer id = Integer.valueOf(idCompany);

        Date dateApertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateApertura = sdf.parse(dateCompany);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        DB db = new DB();
        Company com = db.searchCompany(id);
        com.setName(nameCompany);
        com.setDateApertura(dateApertura);

        resp.sendRedirect("list-company");
    }
}
