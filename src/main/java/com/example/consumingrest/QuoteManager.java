package com.example.consumingrest;

import com.example.consumingrest.domain.Quote;

public interface QuoteManager {
    void sendQuoteNotification(Quote quote);
}