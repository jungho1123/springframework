package myspring.di.xml;
// Assertions 클래스의 모든 static 메서드를 임포트 한다 .
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.context.support.GenericXmlApplicationContext;


public class HellowBeanJunitTest {
    BeanFactory beanFactory;

    @BeforeEach
    void container(){//1 빈 컨테이너 객체 생성
        beanFactory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
    }

    @Test //이걸 반드시 붙여야함
    void hello(){


        // 컨테이너가 xml정보를 읽어서 그걸 파싱 한후 다음에 우리 대신 객체를 생성한다 .

        // hello bean을 컨테이너에 요청하기 bean의 id를 기준으로
        Hello hello = (Hello)beanFactory.getBean("hello");

        // hello bean 을 컨테이너 에게 요청 하기 bean의 id와 Type을 기준으로  Bean을 요청하기
        Hello helloByType= beanFactory.getBean("hello",Hello.class);

        // 2개의 hello bean의 주소 비교
        System.out.println(hello == helloByType);
        // 메서드 사용해서 비교
        assertSame(hello,helloByType);
        //setName() 인젝션 검증하기
        assertEquals("Hello 스프링",helloByType.sayHello());
        //setPrinter() 인젝션 검증하기
        helloByType.print();
        // StringPrinter Bean 요청하기
        Printer printer =beanFactory.getBean("strPrinter", Printer.class);
        assertEquals("Hello 스프링",printer.toString());

    }
}
