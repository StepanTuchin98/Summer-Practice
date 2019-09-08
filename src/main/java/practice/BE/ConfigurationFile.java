package practice.BE;

import practice.BE.clients.EmployeeClient;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationFile {

    @Value("${server.address}")
    private String address;

    @Bean
    public EmployeeClient loginClient() {
        return Feign.builder()
                .client(new OkHttpClient() )
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(EmployeeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(EmployeeClient.class, address);
    }
}

