package Domingo_Reto3.Reto3.service;

import Domingo_Reto3.Reto3.repository.RepositorioQuadbike;
import Domingo_Reto3.Reto3.model.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * clase servicio cuatrimoto
 * trabaja las llamadas, entradas, actualizaciones y borrado en conjunto con los metodos crud
 * @author Andres Diaz
 */
@Service
public class ServiciosQuadbike {
    @Autowired
    private RepositorioQuadbike metodosCrud;
    /**
     * lista todos los elementos contenidos en la tabla cuatrimoto
     * @return 
     */
    public List<Quadbike> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * encuentra una fila espesifica de la tabla cuatrimoto
     * @param quadbikeId
     * @return 
     */
    public Optional<Quadbike> getQuadbike(int quadbikeId) {
        return metodosCrud.getQuadbike(quadbikeId);
    }
    /**
     * verifica el id y le otorga una a la entrada para ser almacenada en la tabla 
     * @param quadbike
     * @return 
     */
    public Quadbike save(Quadbike quadbike){
        if(quadbike.getId()==null){
            return metodosCrud.save(quadbike);
        }else{
            Optional<Quadbike> e=metodosCrud.getQuadbike(quadbike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(quadbike);
            }else{
                return quadbike;
            }
        }
    }
    /**
     * este metodo ubica una fila en la tabla para ser modificada
     * @param quadbike
     * @return 
     */
    public Quadbike update(Quadbike quadbike){
        if(quadbike.getId()!=null){
            Optional<Quadbike> e=metodosCrud.getQuadbike(quadbike.getId());
            if(!e.isEmpty()){
                if(quadbike.getName()!=null){
                    e.get().setName(quadbike.getName());
                }
                if(quadbike.getBrand()!=null){
                    e.get().setBrand(quadbike.getBrand());
                }
                if(quadbike.getYear()!=null){
                    e.get().setYear(quadbike.getYear());
                }
                if(quadbike.getDescription()!=null){
                    e.get().setDescription(quadbike.getDescription());
                }
                if(quadbike.getCategory()!=null){
                    e.get().setCategory(quadbike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return quadbike;
            }
        }else{
            return quadbike;
        }
    }

    /**
     * este metodo recibe un id para ubicar la fila de la tabla y eliminarla
     * @param quadbikeId
     * @return 
     */
    public boolean deleteQuadbike(int quadbikeId) {
        Boolean aBoolean = getQuadbike(quadbikeId).map(quadbike -> {
            metodosCrud.delete(quadbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
