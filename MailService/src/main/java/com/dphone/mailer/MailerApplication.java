package com.dphone.mailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailerApplication.class,args);
        System.out.println("Hello world!");
    }
}