package spring_di;

import org.springframework.stereotype.Component;

@Component("LG")
public class PrinterLG implements Printer{

    public String print(){
        return "Это принер компании LG";
    }
}
