package poclocadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "poclocadora")
public class PocLocadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocLocadoraApplication.class, args);
	}

}
