package com.allthingstesting.TestLib;

import java.util.Properties;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 *
 * @author steve
 */
public class KProducer {

    private KafkaProducer kafkaProducer;

    private Long timestamp;

    public KProducer(String bootstrapServer, String keySerializer, String valueSerializer) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServer);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);

        kafkaProducer = new KafkaProducer(properties);
    }

    public Long syncWrite(String topic, Object key, Object value) {
        timestamp = 0L;

        kafkaProducer.send(new ProducerRecord<>(topic, key, value), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {
                    timestamp = recordMetadata.timestamp();
                } else {
                    System.out.println("Error:" + e);

                }
            }
        });

        return timestamp;
    }

    public void close() {
        kafkaProducer.close();
    }

}
