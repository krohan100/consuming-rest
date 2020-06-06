package com.example.consumingrest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.example.consumingrest.domain.Quote;

@Configuration
public class SimpleQuoteManager implements QuoteManager {
}
