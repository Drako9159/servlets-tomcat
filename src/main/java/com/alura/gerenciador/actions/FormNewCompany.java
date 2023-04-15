package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.Company;
import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FormNewCompany implements Action{
    public String exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:formNewCompany.jsp";
    }
}
