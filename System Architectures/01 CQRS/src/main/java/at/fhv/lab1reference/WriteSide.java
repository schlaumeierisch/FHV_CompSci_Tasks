package at.fhv.lab1reference;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import writeside.domain.api.EventPublisher;
import writeside.infrastructure.EventPublisherImpl;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    private final EventPublisher eventPublisher = new EventPublisherImpl();

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Event event = new Event();
//            event.setContent("This is the content!");
//            event.setCustomer("Customer2");
//            event.setTimestamp(System.currentTimeMillis());
//            System.out.println("Result: " + publisher.publishEvent(event));
        };
    }
}
