package com.calculator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(CalculatorApplication.class, args);
        HttpClient httpClient = HttpClientBuilder.create().build();
        String operation = "add";
        String a = "4";
        String b = "2";
        HttpGet httpRequest = new HttpGet("http://localhost:8081/" + operation + "/" + a+ "/" + b);
        HttpResponse httpResponse = httpClient.execute(httpRequest);
        System.out.println();
        System.out.println("httpResponse = " + httpResponse);

        String responseBody = EntityUtils.toString(httpResponse.getEntity());

        System.out.println();
        System.out.println(responseBody);

    }
}
