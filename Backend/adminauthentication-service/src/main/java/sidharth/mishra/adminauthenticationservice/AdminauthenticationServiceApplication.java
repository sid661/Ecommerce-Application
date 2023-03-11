package sidharth.mishra.adminauthenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminauthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminauthenticationServiceApplication.class, args);
	}

}
