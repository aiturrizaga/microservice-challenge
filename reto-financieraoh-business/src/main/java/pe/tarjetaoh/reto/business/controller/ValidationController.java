package pe.tarjetaoh.reto.business.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tarjetaoh.reto.business.client.PersonalLoanClient;
import pe.tarjetaoh.reto.business.dto.PersonalLoanDTO;
import pe.tarjetaoh.reto.business.exception.ExceptionResponse;
import pe.tarjetaoh.reto.business.service.LoanValidationService;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/loan-validation")
public class ValidationController {

    private final LoanValidationService service;
    private final PersonalLoanClient client;

    public ValidationController(LoanValidationService service, PersonalLoanClient client) {
        this.service = service;
        this.client = client;
    }

    @PostMapping
    public ResponseEntity<Object> registerLoan(@Valid @RequestBody PersonalLoanDTO dto) throws Exception {
        Optional<ExceptionResponse> err = service.businessValidation(dto);
        if (err.isPresent()) {
            return ResponseEntity.badRequest().body(err);
        }

        return client.registerLoan(dto);
    }

    @PutMapping
    public ResponseEntity<Object> updateLoan(@Valid @RequestBody PersonalLoanDTO dto) throws Exception {
        Optional<ExceptionResponse> err = service.businessValidation(dto);
        if (err.isPresent()) {
            return ResponseEntity.badRequest().body(err);
        }

        return client.updateLoan(dto);
    }

}
