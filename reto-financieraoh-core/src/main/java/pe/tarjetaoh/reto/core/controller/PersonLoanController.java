package pe.tarjetaoh.reto.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.tarjetaoh.reto.core.entity.PersonalLoan;
import pe.tarjetaoh.reto.core.exception.NotFoundException;
import pe.tarjetaoh.reto.core.service.IPersonalLoanService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/loans")
public class PersonLoanController {

    private final IPersonalLoanService service;

    public PersonLoanController(IPersonalLoanService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonalLoan>> findAllLoans() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalLoan> findLoanById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException("Loan id not found"));
    }

    @PostMapping
    public ResponseEntity<PersonalLoan> registerLoan(@Valid @RequestBody PersonalLoan personalLoan) throws Exception {
        PersonalLoan loan = service.register(personalLoan);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(loan.getId()).toUri();
        return ResponseEntity.created(location).body(loan);
    }

    @PutMapping
    public ResponseEntity<PersonalLoan> updateLoan(@Valid @RequestBody PersonalLoan personalLoan) throws Exception {
        return ResponseEntity.ok(service.update(personalLoan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("id") Integer id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
