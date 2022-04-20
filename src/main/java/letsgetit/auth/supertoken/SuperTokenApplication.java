package letsgetit.auth.supertoken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SuperTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperTokenApplication.class, args);
	}
}
