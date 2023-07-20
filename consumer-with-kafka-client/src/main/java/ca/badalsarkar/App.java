package ca.badalsarkar;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Properties consumerProperties= new Properties();
        consumerProperties.put("bootstrap.servers","localhost:9092");
        consumerProperties.put("group.id","simple-consumers");
        consumerProperties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        // instantiate consumer
        var consumer = new KafkaConsumer<String, String >(consumerProperties);

        // subscribe to topic
        consumer.subscribe(Collections.singletonList("simple-consumer-topic"));

        // the poll loop
        Duration duration = Duration.ofMillis(100);
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(duration);
        }
    }
}
