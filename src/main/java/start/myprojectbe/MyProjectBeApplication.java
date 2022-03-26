package start.myprojectbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("start")
public class MyProjectBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectBeApplication.class, args);
	}

}
