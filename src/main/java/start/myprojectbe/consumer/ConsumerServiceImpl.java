package start.myprojectbe.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerServiceImpl {
    @KafkaListener(topics = "portfolio-outbound",
    groupId = "test_group")
    public void consumeEvents(ConsumerRecord<String,String> record){
        try{
            log.info("message received {}",record.value());
        }catch(Exception e){
            log.error("error:{}",e.getMessage(),e);
        }

    }
}
