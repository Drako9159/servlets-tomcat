package com.alura.gerenciador.servlet;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/companys")
public class CompanyService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DB database = new DB();
        List<Company> listCompany = database.getListCompany();

        String value = req.getHeader("Accept");

        if (value.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("company", Company.class);
            String xml = xStream.toXML(listCompany);
            resp.setContentType("Application/xml");
            resp.getWriter().print(xml);

        } else if (value.contains("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(listCompany);
            resp.setContentType("Application/json");
            resp.getWriter().print(json);
        } else {
            resp.setContentType("Application/json");
            resp.getWriter().print("{ 'message': 'NO_CONTENT' }");
        }
    }
}
