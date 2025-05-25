
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailOTPUtil {
    private static String currentOTP;

    public static String generateOTP() {
        currentOTP = String.valueOf(100000 + new Random().nextInt(900000));
        return currentOTP;
    }

    public static void sendOTP(String recipientEmail) {
        final String sender = "your_email@gmail.com";
        final String password = "your_app_password";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("OTP Verification");
            message.setText("Your OTP is: " + currentOTP);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static boolean verifyOTP(String input) {
        return input.equals(currentOTP);
    }
}
