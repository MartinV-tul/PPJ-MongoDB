package cz.tul;

import cz.tul.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("cz.tul.repository")
public class Main {

    @Bean
    CountryService countryService(){return new CountryService();}

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext context = app.run(args);
    }
}
