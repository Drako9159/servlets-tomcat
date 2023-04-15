package com.alura.gerenciador.actions;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login {

    public String exect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramLogin = req.getParameter("login");
        String paramPassword = req.getParameter("password");

        DB db = new DB();
        User usr = db.existUser(paramLogin, paramPassword);

        if(usr != null){
            return "redirect:home?action=list-companys";
        } else {

        }
        return null;


    };

}
