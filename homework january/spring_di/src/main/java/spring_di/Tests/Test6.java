package spring_di.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di.Train;

public class Test6 {

    public void runTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Train train = (Train) context.getBean("train");
        System.out.println("пример использования look-method");
        System.out.println(train.createBoom().getDescription());
    }
}
