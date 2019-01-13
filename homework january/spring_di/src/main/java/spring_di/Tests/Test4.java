package spring_di.Tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_di.MyConfiguration;
import spring_di.Office;
import spring_di.Office2;

public class Test4 {

    public void runTest4() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Office2 office = (Office2) applicationContext.getBean(Office2.class);
        Office office2 = (Office) applicationContext.getBean(Office.class);
        System.out.println("примеры использования Autowired");
        System.out.println("офис 2 получает принтер LG через аннатированный Autowired конструктор класса");
        System.out.println(office.getPrinter().print());
        System.out.println();
        System.out.println("офис 1 получает принтер HP через аннатированный Autowired сеттер класса");
        System.out.println("так как метод set у класса Office1 принемает интерфейс Printer, а классов реализующих его 2, то");
        System.out.println("дополнительно указываем класс принтера используя анотацию @Qualifier(HP)");
        System.out.println(office2.getPrinter().print());
        System.out.println();
    }
}
