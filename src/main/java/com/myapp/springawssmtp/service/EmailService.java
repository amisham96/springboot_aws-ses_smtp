package com.myapp.springawssmtp.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailService {

    @Value("${from.email.address}")
    private String fromEmailAddress;
    
    @Autowired
    private SpringTemplateEngine templateEngine;

	@Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String recipient, String subject) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Context context = new Context();
        String content = templateEngine.process("email-template", context);
        
        helper.setFrom(fromEmailAddress, "Your Name");
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

}