package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"mylab.notification.di.annot"})
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);

    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager(EmailNotificationService emailService,
                                                   SmsNotificationService smsService) {

        return new NotificationManager(emailService, smsService);

    }

}
