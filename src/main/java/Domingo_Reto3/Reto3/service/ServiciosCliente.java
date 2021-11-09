package Domingo_Reto3.Reto3.service;

import Domingo_Reto3.Reto3.repository.RepositorioCliente;
import Domingo_Reto3.Reto3.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * clase servicio cliente
 * trabaja las llamadas, entradas, actualizaciones y borrado en conjunto con los metodos crud
 * @author Andres Diaz
 */
@Service
public class ServiciosCliente {
     @Autowired
     private RepositorioCliente metodosCrud;
     /**
      * lista todos los elementos contenidos en la tabla cliente
      * @return 
      */
     public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     /**
      * encuentra una fila espesifica de la tabla cliente
      * @param clientId
      * @return 
      */
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }
    /**
     * verifica el id y le otorga una a la entrada para ser almacenada en la tabla 
     * @param client
     * @return 
     */  
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    /**
     * este metodo ubica una fila en la tabla para ser modificada
     * @param client
     * @return 
     */
    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    /**
     * este metodo recibe un id para ubicar la fila de la tabla y eliminarla
     * @param clientId
     * @return 
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
