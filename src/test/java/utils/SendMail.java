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

        // HTML Report Path
        String htmlReportPath =
                System.getProperty("user.dir")
                + "\\target\\surefire-reports\\emailable-report.html";

        // Excel Report Path
        String excelReportPath =
                System.getProperty("user.dir")
                + "\\Reports\\SanityReport.xlsx";

        System.out.println("HTML Report : "
                + htmlReportPath);

        System.out.println("Excel Report : "
                + excelReportPath);

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(

                props,

                new Authenticator() {

                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                from,
                                password);
                    }
                });

        Message message =
                new MimeMessage(session);

        message.setFrom(
                new InternetAddress(from));

        message.setRecipients(
                Message.RecipientType.TO,

                InternetAddress.parse(to));

        message.setSubject(
                "Automation Execution Report");

        // =========================
        // Email Body
        // =========================

        BodyPart messageBodyPart =
                new MimeBodyPart();

        messageBodyPart.setText(

                "Sanity Suite Execution Completed.\n\n"

              + "Please find attached:\n"

              + "1. HTML Report\n"

              + "2. Excel Execution Report");

        // =========================
        // HTML Attachment
        // =========================

        MimeBodyPart htmlAttachment =
                new MimeBodyPart();

        DataSource htmlSource =

                new FileDataSource(
                        new File(htmlReportPath));

        htmlAttachment.setDataHandler(
                new DataHandler(htmlSource));

        htmlAttachment.setFileName(
                "emailable-report.html");

        // =========================
        // Excel Attachment
        // =========================

        MimeBodyPart excelAttachment =
                new MimeBodyPart();

        DataSource excelSource =

                new FileDataSource(
                        new File(excelReportPath));

        excelAttachment.setDataHandler(
                new DataHandler(excelSource));

        excelAttachment.setFileName(
                "SanityReport.xlsx");

        // =========================
        // Combine Everything
        // =========================

        Multipart multipart =
                new MimeMultipart();

        multipart.addBodyPart(
                messageBodyPart);

        multipart.addBodyPart(
                htmlAttachment);

        multipart.addBodyPart(
                excelAttachment);

        message.setContent(multipart);

        // =========================
        // Send Mail
        // =========================

        Transport.send(message);

        System.out.println(
                "Email Sent Successfully");
    }
}