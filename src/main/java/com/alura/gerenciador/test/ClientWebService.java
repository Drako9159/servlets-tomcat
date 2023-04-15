package com.alura.gerenciador.test;

import org.apache.hc.client5.http.fluent.Request;

public class ClientWebService {
    public static void main(String[] args) throws Exception {

        // SEND REQUESTS
        String content = Request.post("http://localhost:8080/ArrivateTomcat_war_exploded/companys")
                .addHeader("Accept", "Application/json")
                .execute()
                .returnContent().toString();

        System.out.println(content);

    }
}
