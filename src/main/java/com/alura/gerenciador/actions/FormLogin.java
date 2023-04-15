package com.alura.gerenciador.actions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FormLogin {
    public String exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
