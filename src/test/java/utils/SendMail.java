package utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static void sendEmail() throws Exception {

    	String from =
    	        ConfigReader.get("email.username");

    	String password =
    	        ConfigReader.get("email.password");

    	String to =
    	        ConfigReader.get("email.to");

        // Report Path
        String reportPath =
                System.getProperty("user.dir")
                + "\\target\\surefire-reports\\emailable-report.html";
        System.out.println(reportPath);

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,

            new Authenticator() {

                protected PasswordAuthentication
                getPasswordAuthentication() {

                    return new PasswordAuthentication(from, password);
                }
            });

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to));

        message.setSubject("Automation Execution Report");

        // Email Body
        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(
                "Please find attached automation report.");

        // Attachment
        MimeBodyPart attachmentPart = new MimeBodyPart();

        DataSource source =
                new FileDataSource(new File(reportPath));

        attachmentPart.setDataHandler(
                new DataHandler(source));

        attachmentPart.setFileName("emailable-report.html");

        // Combine Body + Attachment
        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        // Send Email
        Transport.send(message);

        System.out.println("Email Sent Successfully");
    }
}