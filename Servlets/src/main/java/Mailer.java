import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

public class Mailer {
    private String SENDER_NAME = "g00dTroll380";  // GMail user name (just the part before "@gmail.com")
    private String PASSWORD = "ddskljsslkns1"; // GMail password
    private String recipient;
    private String host = "smtp.gmail.com";

    private Properties getProperties(String from, String password){
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        return props;
    }

    private Session getSession(Properties properties){
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER_NAME, PASSWORD);
                    }
                });
        return session;
    }

    public void send(String recepient,String theme,String message){
        recipient = recepient;
        Properties props = getProperties(SENDER_NAME, PASSWORD);
        Session session = getSession(props);

        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            mimeMessage.setFrom(new InternetAddress(SENDER_NAME + "@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            mimeMessage.setSubject(theme);
            mimeMessage.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, SENDER_NAME, PASSWORD);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

        } catch (MessagingException e ) {
            e.printStackTrace();
        }
    }
}
