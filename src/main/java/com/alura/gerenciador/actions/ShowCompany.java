package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ShowCompany {
    public void exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        DB db = new DB();
        Company com = db.searchCompany(id);

        RequestDispatcher rd = req.getRequestDispatcher("/formUpdateCompany.jsp");
        req.setAttribute("company", com);
        rd.forward(req, resp);

    }
}
