package com.ageng.belajar_springboot.service;

import org.springframework.stereotype.Service;

import jakarta.mail.*;
import jakarta.mail.internet.*;

@Service
public class EmailService {

    private Session newSession;

    // Constructor Injection
    public EmailService(Session mailSession) {
        this.newSession = mailSession;
    }

    public void sendMail() throws Exception {

        Message message = new MimeMessage(newSession);
        message.setFrom(new InternetAddress("from@example.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("to@example.com"));
        message.setSubject("Mail Subject");
        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Email sent successfully");
    }

}