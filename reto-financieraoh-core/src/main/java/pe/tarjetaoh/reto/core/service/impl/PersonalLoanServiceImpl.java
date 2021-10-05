package pe.tarjetaoh.reto.core.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.tarjetaoh.reto.core.entity.PersonalLoan;
import pe.tarjetaoh.reto.core.repository.IPersonalLoanRepo;
import pe.tarjetaoh.reto.core.service.IPersonalLoanService;

@Service
public class PersonalLoanServiceImpl extends GenericCRUDImpl<PersonalLoan, Integer> implements IPersonalLoanService {

    private final IPersonalLoanRepo repo;

    public PersonalLoanServiceImpl(IPersonalLoanRepo repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<PersonalLoan, Integer> getRepo() {
        return repo;
    }


}
