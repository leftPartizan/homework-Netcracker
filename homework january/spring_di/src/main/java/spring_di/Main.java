package spring_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spring_di.Tests.Test3;
import spring_di.Tests.Test4;
import spring_di.Tests.Test5;
import spring_di.Tests.Test6;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Test6().runTest();
    }
}
