package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout {
    public String exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramLogin = req.getParameter("login");
        String paramPassword = req.getParameter("password");

        HttpSession sesion = req.getSession();
        //sesion.removeAttribute("loginUser"); // option 1
        sesion.invalidate(); // option 2 clean all


        return "redirect:home?action=form-login";

    };
}
