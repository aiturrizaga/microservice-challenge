package pe.tarjetaoh.reto.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RetoFinancieraohEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoFinancieraohEurekaServerApplication.class, args);
	}

}
