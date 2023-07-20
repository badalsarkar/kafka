package ca.badalsarkar.consumerwithspringkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerWithSpringKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerWithSpringKafkaApplication.class, args);
    }

    @KafkaListener(id = "test", topics = "spring-consumer-topic")
    public void listen(String in){
        System.out.println(in);
    }
}
