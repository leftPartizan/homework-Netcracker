package spring_di.Tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_di.Archmage;
import spring_di.MyConfiguration;

public class Test2 {

    public void runTest2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Archmage archmage = (Archmage) applicationContext.getBean("Dovakin");
        System.out.println("пример инжектирования коллекции");
        System.out.println("бин Dovakin через метод сет получет лист врагов бина enemyDovakinList");
        System.out.println();
        System.out.println();
    }
}
