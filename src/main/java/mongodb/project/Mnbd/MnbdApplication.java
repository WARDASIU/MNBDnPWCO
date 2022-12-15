package mongodb.project.Mnbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-test.properties")
public class MnbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MnbdApplication.class, args);
	}

}
