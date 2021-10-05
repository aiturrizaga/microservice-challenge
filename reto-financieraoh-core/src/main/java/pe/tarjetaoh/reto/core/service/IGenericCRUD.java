package pe.tarjetaoh.reto.core.service;

import java.util.List;
import java.util.Optional;

public interface IGenericCRUD<T, ID> {

    T register(T t) throws Exception;

    T update(T t) throws Exception;

    List<T> findAll() throws Exception;

    Optional<T> findById(ID id) throws Exception;

    void deleteById(ID id) throws Exception;

}
