package spring_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Office {

    Printer printer;

    public Printer getPrinter() {
        return printer;
    }

    @Autowired
    public void setPrinter(@Qualifier("HP") Printer printer) {
        this.printer = printer;
    }

}
