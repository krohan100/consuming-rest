package com.example.consumingrest;

import com.example.consumingrest.domain.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import java.util.logging.Logger;

@SpringBootApplication
public class ConsumingQuoteRestApplication {

	private static final Logger log =  Logger.getLogger(String.valueOf(ConsumingQuoteRestApplication.class));

	public static void main(String[] args) {
		SpringApplication.run(ConsumingQuoteRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info("Quote retrieved: " + quote.toString());
		};
	}
}
