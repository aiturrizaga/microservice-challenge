package pe.tarjetaoh.reto.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class RetoFinancieraohGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoFinancieraohGatewayApplication.class, args);
	}

}
