package myspring.di.xml.config;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HelloConfig.class})
public class HelloConfigTest {
    @Autowired
    Hello hello;
    @Autowired
    Printer stringPrinter;
    @Test
    void hello() {
        assertEquals("Hello 스프링", hello.sayHello());
        hello.print();
        assertEquals("Hello 스프링",stringPrinter.toString());

    }

}
