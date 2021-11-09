package Domingo_Reto3.Reto3.service;

import Domingo_Reto3.Reto3.repository.RepositorioCategoria;
import Domingo_Reto3.Reto3.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**clase servicio categoria
 * trabaja las llamadas, entradas, actualizaciones y borrado en conjunto con los metodos crud
 * 
 * @author Andres Diaz
 */
@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;
    /**
     * lista todos los elementos contenidos en la tabla categoria
     * @return 
     */
    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }
    /**
     * encuentra una fila espesifica de la tabla categoria
     * @param CategoriaId
     * @return 
     */
    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }
    /**verifica el id y le otorga una a la entrada para ser almacenada en la tabla 
     * 
     * @param categoria
     * @return 
     */
    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }
    /**
     * este metodo ubica una fila en la tabla para ser modificada 
     * @param categoria
     * @return 
     */
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    /**
     * este metodo recibe un id para ubicar la fila de la tabla y eliminarla
     * @param categoriaId
     * @return 
     */
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
