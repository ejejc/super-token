package letsgetit.auth.supertoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SuperTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperTokenApplication.class, args);
	}

}
