package start.myprojectbe.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@EnableKafka
@Configuration
@Slf4j
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrap-server}")
    private String bootStrapServer;
    @Value("${kafka.client-id}")
    private String clientId;
    @Value("${kafka.acks}")
    private String acks;
    @Value("${kafka.retries}")
    private String retries;

//    @Bean
//    ConcurrentKafkaListenerContainerFactoryConfigurer concurrentKafkaListenerContainerFactoryConfigurer(){
//        return new ConcurrentKafkaListenerContainerFactoryConfigurer();
//    }
//    @Bean
//    ConcurrentKafkaListenerContainerFactory<Object,Object> concurrentKafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer
//                    concurrentKafkaListenerContainerFactoryConfigurer){
//        ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        ConsumerFactory<Object,Object> consumerFactory = new DefaultKafkaConsumerFactory<>(consumerConfig());
//        factory.setConsumerFactory(consumerFactory);
//        factory.setErrorHandler(errorHandler((consumerRecord, e) -> {
//            log.error("Error occurred while reading events {}",consumerRecord.value());
//        }));
//        concurrentKafkaListenerContainerFactoryConfigurer.configure(factory,consumerFactory);
//        return factory;
//    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootStrapServer);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "test_group");
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

//    @Bean
//    public SeekToCurrentErrorHandler errorHandler(BiConsumer<ConsumerRecord<?, ?>, Exception> recoverer) {
//        SeekToCurrentErrorHandler handler = new SeekToCurrentErrorHandler(recoverer);
//        //handler.addNotRetryableExceptions(IllegalArgumentException.class);
//        return handler;
//    }
//
//
//    private Map<String, Object> consumerConfig(){
//        KafkaProperties kafkaProperties = new KafkaProperties();
//        Map<String,Object> configProps = kafkaProperties.buildProducerProperties();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
//        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//        configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"test_grp");
//        return configProps;
//    }
}
