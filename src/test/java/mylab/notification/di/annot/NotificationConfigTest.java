package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NotificationConfig.class})
public class NotificationConfigTest {
    @Autowired
    NotificationManager notificationManager;
    @Autowired
    EmailNotificationService emailService;
    @Autowired
    SmsNotificationService smsService;

    @Test
    void notificationManagerTest() {
        assertNotNull(notificationManager);
    }

    @Test
    void emailServiceTest() {
        assertNotNull(notificationManager.getEmailService());
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());
        assertSame(emailService, notificationManager.getEmailService());

    }

    @Test
    void smsServiceTest() {
        assertNotNull(smsService);
        assertNotNull(notificationManager.getSmsService());
        assertEquals("SKT", smsService.getProvider());
        assertSame(smsService, notificationManager.getSmsService());
    }

    @Test
    void NotificationManagerTest() {
        assertNotNull(notificationManager);
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }

}
