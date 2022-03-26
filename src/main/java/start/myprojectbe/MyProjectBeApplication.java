package start.myprojectbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@ComponentScan("start")
public class MyProjectBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectBeApplication.class, args);
	}

}
