package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListCompany {
    public void exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB database = new DB();
        List<Company> listCompany = database.getListCompany();

        //dispatch
        RequestDispatcher rd = req.getRequestDispatcher("/listCompany.jsp");
        req.setAttribute("companys", listCompany);
        rd.forward(req, resp);
    }
}
