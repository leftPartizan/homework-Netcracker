package com.crud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) throws com.fasterxml.jackson.core.JsonProcessingException{
        SpringApplication.run(CrudApplication.class, args);
    }

}

