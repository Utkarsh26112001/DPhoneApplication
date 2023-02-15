package com.dphone.mailer.controller;



import com.dphone.mailer.bean.EmailDetails;
import com.dphone.mailer.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dphonemailservice")
public class EmailController {

    @Autowired

    private EmailService emailService;

    @PostMapping("/sendMail")

    public String sendMail (@RequestBody EmailDetails details){
        String status
                = emailService.sendSimpleMail(details);

        return status;

    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details) throws MessagingException {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }

}
