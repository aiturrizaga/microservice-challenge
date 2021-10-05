package pe.tarjetaoh.reto.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pe.tarjetaoh.reto.business.config.AppProperties;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(value = {AppProperties.class})
public class RetoFinancieraohBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoFinancieraohBusinessApplication.class, args);
	}

}
