package myspring.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloBean {
    @Value("${app.setter.name}")
    String name;
    @Autowired   //
    @Qualifier("stringPrinter")
    PrinterBean printer;
    List<String> names;

    public HelloBean() {
        System.out.println(this.getClass().getName() + "기본 생성자 호출됨 ");
    }

//	public HelloBean(String name, PrinterBean printer) {
//		System.out.println(this.getClass().getName() +"오버로딩 생성자 호출됨 ");
//		this.name = name;
//		this.printer = printer;
//	}

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> list) {
        this.names = list;
    }

    public void setName(String name) {
        System.out.println("setName : " + name);
        this.name = name;
    }

    public void setPrinter(PrinterBean printer) {
        System.out.println("setPrinter : " + printer.getClass().getName());
        this.printer = printer;
    }

    public String sayHello() {
        return "Hello " + name;
    }

    public void print() {
        this.printer.print(sayHello());
    }

}
