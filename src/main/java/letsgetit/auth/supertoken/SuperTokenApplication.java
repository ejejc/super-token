package letsgetit.auth.supertoken;

import letsgetit.auth.supertoken.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class SuperTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperTokenApplication.class, args);
	}

}
