package start.myprojectbe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import start.myprojectbe.dto.OrderDto;
import start.myprojectbe.producer.OrderProducerService;

@RestController
@Slf4j
public class PortFolioController {
    @Autowired
    private OrderProducerService orderProducerService;
    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto){
       try{
           log.info("order received:{}",orderDto);
           orderProducerService.publishOrder(orderDto);
       }catch(Exception e){
           log.error(e.getMessage(),e);
       }
       return ResponseEntity.ok("Success");
    }
}
