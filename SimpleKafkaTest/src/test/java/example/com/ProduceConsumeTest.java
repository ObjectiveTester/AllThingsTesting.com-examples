package example.com;

import com.allthingstesting.TestLib.KConsumer;
import com.allthingstesting.TestLib.KProducer;
import java.util.Random;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * simple Kafka test
 *
 */
public class ProduceConsumeTest {

    static KProducer producer;
    static KConsumer consumer;

    public ProduceConsumeTest() {
    }

    @BeforeAll
    public static void setUpAll() {
        producer = new KProducer("localhost:9092",
                "org.apache.kafka.common.serialization.IntegerSerializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        consumer = new KConsumer("localhost:9092",
                "org.apache.kafka.common.serialization.IntegerDeserializer",
                "org.apache.kafka.common.serialization.StringDeserializer",
                "test-group", "multi-partition", new int[]{0, 1});

    }

    @Test
    public void produceconsume() {
        Random random = new Random();
        Integer testkey = random.nextInt(100);
        System.out.println("testkey:" + testkey);

        //move consumer group offset to the end - so the next record consumed should be the one we write
        consumer.skipForward();

        //write a test record
        producer.syncWrite("multi-partition", testkey, "test data " + testkey);

        
        
        //consume a single record
        ConsumerRecords<Object, Object> records = consumer.readNext(10000L);

        assertEquals(1, records.count());

        //assert the key and value are correct
        for (ConsumerRecord<Object, Object> record : records) {

            System.out.println(String.format("Read from partition %d, offset %d", record.partition(), record.offset()));

            assertEquals(testkey, record.key());
            assertEquals("test data " + testkey, record.value());

        }

    }

    @AfterAll
    public static void tearDownAll() {
        producer.close();
    }
}
