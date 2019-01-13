package spring_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Office2 {

    Printer printer;

    public Printer getPrinter() {
        return printer;
    }


    @Autowired
    public Office2(PrinterLG printer) {
        this.printer = printer;
    }
}