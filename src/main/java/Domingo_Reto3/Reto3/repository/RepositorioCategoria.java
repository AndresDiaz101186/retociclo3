package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceCategoria;
import Domingo_Reto3.Reto3.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**clase repositorio categoria
 * 
 * @author Andres Diaz
 */
@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud;
    /**
     * devuelve todo lo contenido en la tabla categoria
     * @return 
     */
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    /**
     * encuentra un elemento espesifico de categoria por el id
     * @param id
     * @return 
     */
    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }
    /**
     * guarda datos en la tabla categoria 
     * @param Categoria
     * @return 
     */
    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    /**
     * borra elementos de la tabla categoria
     * @param Categoria 
     */
    public void delete(Categoria Categoria){
       crud.delete(Categoria);
    }
}

