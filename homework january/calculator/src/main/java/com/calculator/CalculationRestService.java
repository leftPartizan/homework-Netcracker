package com.calculator;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculationRestService {


    @GetMapping(value = "/add/{a}/{b}", produces = MediaType.TEXT_HTML_VALUE)
    public String add (@PathVariable("a") double a, @PathVariable("b") double b ){
        double result = a + b ;
        return "<div> Result of add </div> <br> <div> " + result + " </div>";
    }

    @GetMapping(value = "/deduct/{a}/{b}", produces = MediaType.TEXT_HTML_VALUE)
    public String deduct (@PathVariable("a") double a, @PathVariable("b") double b ){
        double result = a - b ;
        return "<div> Result of add </div> <br> <div> " + result + " </div>";
    }
    @GetMapping(value = "/multiply/{a}/{b}", produces = MediaType.TEXT_HTML_VALUE)
    public String multiply(@PathVariable("a") double a, @PathVariable("b") double b ){
        double result = a * b ;
        return "<div> Result of add </div> <br> <div> " + result + " </div>";
    }
    @GetMapping(value = "/divide/{a}/{b}", produces = MediaType.TEXT_HTML_VALUE)
    public String divide(@PathVariable("a") double a, @PathVariable("b") double b ){

        if (b == 0.0){
            return "<div> Result of add </div> <br> <div> INF </div>";
        }else {
            double result = a/b ;
            return "<div> Result of add </div> <br> <div> " + result + " </div>";
        }
    }
}
