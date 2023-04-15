package com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DB {
    private static List<Company> listCompany = new ArrayList<>();
    private static List<User> listUsers = new ArrayList<>();
    private static Integer secuencialKey = 1;

    static {
        Company company = new Company();
        company.setName("Alura");
        company.setId(DB.secuencialKey++);
        Company company2 = new Company();
        company2.setName("Bimbo");
        company2.setId(DB.secuencialKey++);
        Company company3 = new Company();
        company3.setName("Coca-Cola");
        company3.setId(DB.secuencialKey++);

        DB.listCompany.add(company);
        DB.listCompany.add(company2);
        DB.listCompany.add(company3);

        User u1 = new User();
        u1.setLogin("Drako");
        u1.setPassword("0000");
        User u2 = new User();
        u2.setLogin("Dilan");
        u2.setPassword("1234");

        DB.listUsers.add(u1);
        DB.listUsers.add(u2);

    }

    public void addCompany(Company company) {
        company.setId(DB.secuencialKey++);
        DB.listCompany.add(company);
    }

    public List<Company> getListCompany() {
        return DB.listCompany;
    }

    public void deleteCompany(Integer id) {
        Iterator<Company> it = listCompany.iterator();
        while (it.hasNext()) {
            Company com = it.next();
            if (com.getId() == id) {
                it.remove();
            }
        }
    }

    public Company searchCompany(Integer id) {
        for (Company company : listCompany) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }
    public User existUser(String paramLogin, String paramPassword){
        for(User user : listUsers){
            if(user.isEqual(paramLogin, paramPassword)){
                return user;
            }
        }
        return null;
    }
}
