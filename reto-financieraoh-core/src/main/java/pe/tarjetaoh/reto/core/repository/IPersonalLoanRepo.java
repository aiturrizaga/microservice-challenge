package pe.tarjetaoh.reto.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tarjetaoh.reto.core.entity.PersonalLoan;

public interface IPersonalLoanRepo extends JpaRepository<PersonalLoan, Integer> {
}
