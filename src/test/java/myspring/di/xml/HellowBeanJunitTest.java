package myspring.di.xml;

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
        // hello bean을 컨테이너에 요청하기
        Hello hello = (Hello)beanFactory.getBean("hello");
    }
}
