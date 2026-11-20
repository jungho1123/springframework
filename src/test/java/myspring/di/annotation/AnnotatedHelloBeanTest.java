package myspring.di.annotation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @Test
    void hello() {
        assertEquals("Hello 어노테이션", helloBean.sayHello());
        helloBean.print();
        assertEquals("Hello 어노테이션", stringPrinter.toString());

        assertEquals("Hello 어노테이션", printer.toString());
    }

}
