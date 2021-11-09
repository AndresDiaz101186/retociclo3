package Domingo_Reto3.Reto3.controller;

import Domingo_Reto3.Reto3.service.ServiciosCategoria;
import Domingo_Reto3.Reto3.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * clase controladorcategoria escucha los llamados en la paguina para orientar 
 * las acciones que realizaran los servicios y los metodos crud en las tablas 
 * @author Andres Diaz
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCategoria {
    @Autowired
    private ServiciosCategoria servicio;
    /**
     * este mapeo orienta al llamado de todos los elementos contenidos en la tabla categoria
     * @return 
     */
    @GetMapping("/all")
    public List<Categoria> getCategoria(){
        return servicio.getAll();
    }
    /**
     * este mapeo orienta al llamado de un a fila de la tabla categoria
     * @param categoriaId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int categoriaId) {
        return servicio.getCategoria(categoriaId);
    }
    /**
     * este mapeo orienta al servicio de guardado de datos en la tabla categoria 
     * @param categoria
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return servicio.save(categoria);
    }
    /**
     * este mapeo orienta al servicio de actualizacion de datos en la tabla categoria 
     * @param categoria
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return servicio.update(categoria);
    }
    /**
     * este mapeo orienta al servicio de borrado de datos en la tabla categoria 
     * @param categoriaId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicio.deletecategoria(categoriaId);
    }

    
}
