package dev.lucasmachado.config;

import dev.lucasmachado.services.email.EmailService;
import dev.lucasmachado.services.email.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DefaultConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }

}
