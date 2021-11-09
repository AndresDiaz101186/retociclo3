package Domingo_Reto3.Reto3.interfaces;

import Domingo_Reto3.Reto3.model.Categoria;
import org.springframework.data.repository.CrudRepository;
/**
 * interfase de categoria para los metodos crud
 * @author Andres Diaz
 */
public interface InterfaceCategoria extends CrudRepository<Categoria,Integer> {
    
}

