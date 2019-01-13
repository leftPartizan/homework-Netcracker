package spring_di.Tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di.Person;
import spring_di.Pikachu;


public class Test3 {
    public void runTest3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("пример наседования бинов");
        System.out.println("бин Pikachu наследуется от бина Person");
        System.out.println("от Person пикачу получил статус спит ");
        System.out.println();
        Person person = (Person) context.getBean("Noname");
        System.out.println("имя "+ person.getName());
        System.out.println("статус " +person.getStatus());
        System.out.println();

        Pikachu pikachu = (Pikachu) context.getBean("Pikachu");
        System.out.println("имя " + pikachu.getName());
        System.out.println("статус " + pikachu.getStatus());
        System.out.println("он это умеет " + pikachu.getAttack());
    }
}
