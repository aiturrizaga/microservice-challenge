package pe.tarjetaoh.reto.business.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class AppProperties {

    private FeignClient feignClient;

    public static class FeignClient {
        private String coreService;

        public String getCoreService() {
            return coreService;
        }

        public void setCoreService(String coreService) {
            this.coreService = coreService;
        }
    }

    public FeignClient getFeignClient() {
        return feignClient;
    }

    public void setFeignClient(FeignClient feignClient) {
        this.feignClient = feignClient;
    }
}
