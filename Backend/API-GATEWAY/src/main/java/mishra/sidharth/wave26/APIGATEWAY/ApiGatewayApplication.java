package mishra.sidharth.wave26.APIGATEWAY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableEurekaClient
@Configuration
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder)
	{ //admin-service
     return  routeLocatorBuilder.routes().
		route(x->x.path("/user/**").uri("lb://user-service")).
			 route(y->y.path("/userauth/**").uri("lb://userauth-service")).
			 route(r->r.path("/AdminAuthentication/**").uri("lb://adminauth-service")).
					 route(m->m.path("/admin/**").uri("lb://admin-service")).
			 route(z->z.path("/product/**").uri("lb://product-service"))
			 .build();

	}

}
