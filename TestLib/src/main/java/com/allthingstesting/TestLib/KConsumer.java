package com.allthingstesting.TestLib;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

/**
 *
 * @author steve
 */
public class KConsumer {

    private final KafkaConsumer kafkaConsumer;
    private final List<TopicPartition> partitionList;

    public KConsumer(String bootstrapServer, String keySerializer, String valueSerializer,
            String consumerGroup, String topic, int[] partitions) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServer);
        properties.put("key.deserializer", keySerializer);
        properties.put("value.deserializer", valueSerializer);
        properties.put("group.id", consumerGroup);
        properties.put("enable.auto.commit", "true");
        properties.put("auto.offset.reset", "latest");
        properties.put("max.poll.records", "1");

        kafkaConsumer = new KafkaConsumer(properties);

        partitionList = new ArrayList();
        for (int i = 0; i < partitions.length; i++) {
            partitionList.add(new TopicPartition(topic, partitions[i]));
        }

        kafkaConsumer.assign(partitionList);
    }

    public ConsumerRecords readNext(Long timeout) {
        ConsumerRecords<Object, Object> records;
        records = kafkaConsumer.poll(timeout);
        kafkaConsumer.commitAsync();

        return records;
    }

    public void skipForward() {
        kafkaConsumer.seekToEnd(partitionList);
        kafkaConsumer.poll(0);
    }

}
