package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * XML 설정에서 세터와 생성자로 구성한 두 {@link Hello} 빈의 인사말을 검증한다.
 * {@link HellowBeanJunitTest}에서는 빈을 직접 조회하고, 여기서는 필드에 주입받는다.
 *
 * <p>{@link Autowired}는 필드, 생성자, 세터를 포함한 메서드에 사용할 수 있으며,
 * 스프링은 타입을 기준으로 주입할 빈을 찾는다.
 * XML의 {@code <property>}와 {@code <constructor-arg>}는 빈을 구성할 때 주입할 값이나 빈 참조를 지정한다.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
    @Autowired
    Hello hello;

    // 같은 타입의 빈이 두 개이므로 이름으로 주입할 빈을 지정한다.
    @Autowired
    @Qualifier("helloCons")
    Hello helloCons;

    // @Resource - Bean의 name(id) 값으로 의존하는 객체를 찾는 방식.
    @Resource(name = "helloCons")
    Hello hello3;
    @Test
    void helloBean(){
        assertEquals("Hello 스프링",hello.sayHello());
        assertEquals("Hello 생성자",helloCons.sayHello());
        assertEquals("Hello 생성자", hello3.sayHello());
        helloCons.print();

    }
}
