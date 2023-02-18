package com.dphone.mailer.service;
import com.dphone.mailer.bean.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
//    @Autowired
//    private Environment env;

    @Value("${spring.mail.username}")
    private String sender;





    @Override
    public String sendSimpleMail(EmailDetails details) {

        EmailDetails obj = details;
        System.out.println(sender);

        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);

            return "Mail sent successfully";

        }catch (Exception e){

            return  "Error sending mail" + e;
        }


    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) throws MessagingException {

        MimeMessage mineMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper;

        try{

            mimeMessageHelper = new MimeMessageHelper(mineMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(),file);

            javaMailSender.send(mineMessage);

            return "mail sent with attachment";

        }catch (Exception e){

            return "error sending mail" + e;
        }


    }
}
