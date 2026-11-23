package mylab.user.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserServiceTest 클래스를 작성하세요.
 * UserService 를 주입 받기
 * UserService의 레퍼런스가 Not Null 인지 검증 ( assertNotNull() )
 * userService.getUserRepository() 가 Not Null 인지 검증
 * userService.getUserRepository().getDbType() 값이 MySQL 인지 값을 비교하기
 * userService.getSecurityService() 가 Not Null 인지 검증
 * userService.registerUser() 메서드가 True 와 False 인 검증 ( assertTrue / assertFalse )
 * password가 전달되면 True / 전달되지 않으면 False
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void UserTest() {
        assertNotNull(userService);
        assertNotNull(userService.getUserRepository());
        assertEquals(true, userService.getUserRepository().getDbType().equals("MySQL"));
        assertNotNull(userService.getSecurityService());

    }

    @Test
    void registerUserTest() {

        // 1. 비밀번호를 전달한 경우
        boolean result1 = userService.registerUser(
                "user01", "홍길동", "1234"
        );

        assertTrue(result1);

        // 2. 비밀번호를 전달하지 않은 경우
        boolean result2 = userService.registerUser(
                "user02", "김철수", null
        );

        assertFalse(result2);
    }


}
