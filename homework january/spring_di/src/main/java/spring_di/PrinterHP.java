package spring_di;

import org.springframework.stereotype.Component;

@Component("HP")
public class PrinterHP implements Printer{

    public String print(){
        return "Это принер компании HP";
    }
}
