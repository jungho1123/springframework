package myspring.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HellowBeanJunitTest {
    @Test //이걸 반드시 붙여야함
    void hello(){
        //1 빈 컨테이너 객체 생성
        BeanFactory beanFactory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
        // 컨테이너가 xml정보를 읽어서 그걸 파싱 한후 다음에 우리 대신 객체를 생성한다 .

        // hello bean을 컨테이너에 요청하기 bean의 id를 기준으로
        Hello hello = (Hello)beanFactory.getBean("hello");

        // hello bean 을 컨테이너 에게 요청 하기 bean의 id와 Type을 기준으로  Bean을 요청하기
        Hello helloByType= beanFactory.getBean("hello",Hello.class);

        // 2개의 hello bean의 주소 비교
        System.out.println(hello == helloByType);
        // 메서드 사용해서 비교
        Assertions.assertSame(hello,helloByType);
        // 여기서 무엇을 알 수 있느냐

    }
}
