package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class ListCompany implements Action {
    public String exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB database = new DB();
        List<Company> listCompany = database.getListCompany();
        //dispatch
        req.setAttribute("companys", listCompany);
        return "forward:listCompany.jsp";

    }
}
