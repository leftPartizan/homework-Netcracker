package spring_di.Tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_di.Archmage;
import spring_di.MyConfiguration;

public class Test1 {

    public void runTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Archmage archmage = (Archmage) applicationContext.getBean("Sheogarat");
        Archmage archmage2 = (Archmage) applicationContext.getBean("Dovakin");

        System.out.println("инжектируем бин staff1 в Sheogarat бин через метод set");
        System.out.println("шеогарат получает посох вабаджек...");
        System.out.println("имя нашего мага" + archmage.getName());
        System.out.println("характеристики его посоха" + archmage.getStaff().toString());
        System.out.println();
        System.out.println("значение level у посоха получено путём инжектирования @Value level из MyConfiguration" +
                " в бин staff1 через метод set");
        System.out.println();
        System.out.println();
        System.out.println("инжектируем через конструктор бин staff2 в бин Dovalin");
        System.out.println("имя нашего мага" + archmage.getName());
        System.out.println("характеристики его посоха" + archmage.getStaff().toString());
        System.out.println();
        System.out.println();
    }

}
