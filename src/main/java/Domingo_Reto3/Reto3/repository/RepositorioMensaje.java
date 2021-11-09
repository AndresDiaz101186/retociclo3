package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceMensaje;
import Domingo_Reto3.Reto3.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * clase repositorio mensaje
 * @author Andres Diaz
 */
@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud3;
    /**
     * devuelve todo lo contenido en la tabla mensajes
     * @return 
     */
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud3.findAll();
    }
    /**
     * encuentra un elemento espesifico de mensajes por el id
     * @param id
     * @return 
     */
    public Optional<Mensaje> getMessage(int id){
        return crud3.findById(id);
    }
    /**
     * guarda datos en la tabla mensajes
     * @param message
     * @return 
     */
    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    /**
     * borra elementos de la tabla mensajes
     * @param message 
     */
    public void delete(Mensaje message){
        crud3.delete(message);
    }
}

