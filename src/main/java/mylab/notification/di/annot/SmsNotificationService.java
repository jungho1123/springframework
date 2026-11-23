package mylab.notification.di.annot;

public class SmsNotificationService implements NotificationService {
    private String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }
    public String getProvider() {
        return provider;
    }
    @Override
    public void sendNotification(String message) {
        System.out.println("sms알림전송:"+message+"제공업체"+provider);
    }
}
