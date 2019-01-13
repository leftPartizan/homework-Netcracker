package spring_di.Tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di.Animal;

public class Test5 {

    public void runTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("использование Factory-method");
        Animal cat = (Animal) context.getBean("cat");
        Animal dog = (Animal) context.getBean("dog");
        System.out.println(cat);
        System.out.println();
        System.out.println(dog);
        System.out.println();
        System.out.println("использование Factory Bean");
        Animal lion = (Animal) context.getBean("lion");
        System.out.println(lion);
    }
}
