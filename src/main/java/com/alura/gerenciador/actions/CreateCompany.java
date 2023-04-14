package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCompany {
    public void exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("New company register");
        String nameCompany = req.getParameter("name");
        String dateCompany = req.getParameter("fecha");


        Date dateApertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateApertura = sdf.parse(dateCompany);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company company = new Company();
        company.setName(nameCompany);
        company.setDateApertura(dateApertura);


        DB database = new DB();
        database.addCompany(company);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>New company register : " + nameCompany + "</h2>");
        out.println("</body>");
        out.println("</html>");

        resp.sendRedirect("home?action=list-companys");

        //dispatch
        /*
        RequestDispatcher rd = req.getRequestDispatcher("/list-company");
        req.setAttribute("company", company.getName());
        rd.forward(req, resp);*/
    }
}
