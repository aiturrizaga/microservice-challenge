package pe.tarjetaoh.reto.core.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tarjetaoh.reto.core.service.IGenericCRUD;

import java.util.List;
import java.util.Optional;

public abstract class GenericCRUDImpl<T, ID> implements IGenericCRUD<T, ID> {

    protected abstract JpaRepository<T, ID> getRepo();

    @Override
    public T register(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public Optional<T> findById(ID id) throws Exception {
        return Optional.of(getRepo().findById(id).orElse(null));
    }

    @Override
    public void deleteById(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
