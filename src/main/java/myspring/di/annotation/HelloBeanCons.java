package myspring.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloBeanCons {
    String name;
    PrinterBean printer;
    List<String> names;

    @Autowired
    public HelloBeanCons(
            @Value("어노테이션 생성자") String name,
            @Qualifier("stringPrinter") PrinterBean printer) {
        this.name = name;
        this.printer = printer;
        System.out.println(this.getClass().getName());
    }

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String sayHello() {
        return "Hello" + name;
    }

    public void print() {
        this.printer.print(sayHello());
    }
}
