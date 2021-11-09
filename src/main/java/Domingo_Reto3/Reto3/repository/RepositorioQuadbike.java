package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceQuadbike;
import Domingo_Reto3.Reto3.model.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**clase repositorio cuatrimoto
 * 
 * @author Andres Diaz
 */
@Repository
public class RepositorioQuadbike {
    
    @Autowired
    private InterfaceQuadbike crud;
    /**
     * devuelve todo lo contenido en la tabla cuatrimoto
     * @return 
     */
    public List<Quadbike> getAll(){
        return (List<Quadbike>) crud.findAll();
    }
    /**
     * encuentra un elemento espesifico de cuatrimoto por el id
     * @param id
     * @return 
     */
    public Optional<Quadbike> getQuadbike(int id){
        return crud.findById(id);
    }
    /**
     * guarda datos en la tabla cuatrimoto
     * @return 
     */
    public Quadbike save(Quadbike quadbike){
        return crud.save(quadbike);
    }
    /**
     * borra elementos de la tabla cuatrimoto
     * @param quadbike 
     */
    public void delete(Quadbike quadbike){
        crud.delete(quadbike);
    }
}
