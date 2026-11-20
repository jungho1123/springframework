package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)//
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
    @Autowired
    Hello hello; //어노테이션 하나로 얘랑 HellowBeanJunitTest.java  27,30번줄 코드랑 똑같다니 엄청나군
    // hello에는
    @Autowired
    @Qualifier("helloCons")
    Hello helloCons;

    @Test
    void helloBean(){
        assertEquals("Hello 스프링",hello.sayHello());
        assertEquals("Hello 생성자",helloCons.sayHello());

    }
}
