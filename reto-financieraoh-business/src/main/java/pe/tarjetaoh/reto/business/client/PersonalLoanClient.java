package pe.tarjetaoh.reto.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.tarjetaoh.reto.business.dto.PersonalLoanDTO;

import javax.validation.Valid;

@FeignClient(value = "personalLoanClient", url = "${app.feign-client.core-service}")
@RequestMapping("/loans")
public interface PersonalLoanClient {

    @PostMapping
    ResponseEntity<Object> registerLoan(@Valid @RequestBody PersonalLoanDTO dto) throws Exception;

    @PutMapping
    ResponseEntity<Object> updateLoan(@Valid @RequestBody PersonalLoanDTO dto) throws Exception;
}
