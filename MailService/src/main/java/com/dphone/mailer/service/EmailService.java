package com.dphone.mailer.service;

import com.dphone.mailer.bean.EmailDetails;
import jakarta.mail.MessagingException;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details) throws MessagingException;
}
