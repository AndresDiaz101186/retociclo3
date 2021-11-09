package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceCliente;
import Domingo_Reto3.Reto3.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio cliente
 * @author Andres Diaz
 */
@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud1;
    /**
     * devuelve todo lo contenido en la tabla cliente
     * @return 
     */
    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    /**
     * encuentra un elemento espesifico de cliente por el id
     * @param id
     * @return 
     */
    public Optional<Cliente> getCliente(int id){
        return crud1.findById(id);
    }
    /**
     * guarda datos en la tabla cliente
     * @param cliente
     * @return 
     */
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
    /**
     * borra elementos de la tabla cliente
     * @param cliente 
     */
    public void delete(Cliente cliente){
        crud1.delete(cliente);
    }
}

