package pe.tarjetaoh.reto.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RetoFinancieraohCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoFinancieraohCoreApplication.class, args);
	}

}
