package com.alura.gerenciador.servlet;

import java.util.Date;

public class Company {
    private String name;
    private Integer id;
    private Date dateApertura = new Date();

    public Date getDateApertura() {
        return dateApertura;
    }


    public void setDateApertura(Date dateApertura) {
        this.dateApertura = dateApertura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
