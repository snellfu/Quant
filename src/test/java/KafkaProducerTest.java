import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.hashids.Hashids;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerTest {

    private static KafkaProducer<String, String> producer;
    private final static String TOPIC = "mykafka";

    public KafkaProducerTest() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置分区类,根据key进行数据分区
        producer = new KafkaProducer<String, String>(props);
    }

    public void produce()throws Exception {
        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            String data = "hello kafka fmessage：" + key;
            Future<RecordMetadata> future =producer.send(new ProducerRecord<String, String>(TOPIC, key, data));
            future.get().hasOffset();
            System.out.println(data);
        }
        producer.close();
    }

    public static void main(String[] args) throws Exception{
        new KafkaProducerTest().produce();
    }
}
