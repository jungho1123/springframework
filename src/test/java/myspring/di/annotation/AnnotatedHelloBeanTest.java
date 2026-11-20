package myspring.di.annotation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-anno.xml")
public class AnnotatedHelloBeanTest {
    @Autowired
    HelloBean helloBean;
    @Autowired
    PrinterBean stringPrinter;
    @Autowired
    @Qualifier("stringPrinter")
    PrinterBean printer;
    @Resource(name = "stringPrinter")
    PrinterBean stringPrinter2;

    @Autowired
    HelloBeanCons helloBeanCons;

    @Autowired
    @Qualifier("stringPrinter")
    PrinterBean printerCons;


    @Test
    @Disabled
    void hello() {
        assertEquals("Hello 어노테이션", helloBean.sayHello());
        helloBean.print();
        assertEquals("Hello 어노테이션", stringPrinter.toString());

        assertEquals("Hello 어노테이션", printer.toString());
        assertEquals("Hello 어노테이션", stringPrinter2.toString());
    }

    @Test
    void hello_constructor() {
        assertEquals("Hello어노테이션생성자app.setter.name", helloBeanCons.sayHello());
        helloBeanCons.print();
        for (String name : helloBeanCons.getNames()) {
            System.out.println(name);
        }
        assertEquals(3, helloBeanCons.getNames().size());
        assertEquals("java", helloBeanCons.getNames().get(0));
    }



    }


