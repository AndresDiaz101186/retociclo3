package Domingo_Reto3.Reto3.controller;

import Domingo_Reto3.Reto3.service.ServiciosQuadbike;
import Domingo_Reto3.Reto3.model.Quadbike;
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
 * este mapeo orienta al llamado de todos los elementos contenidos en la tabla cuatrimoto
 * @author Andres Diaz
 */
@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorQuadbike {
    @Autowired
    private ServiciosQuadbike servicio;
    /**
     * este mapeo orienta al llamado de todos los elementos contenidos en la tabla cuatrimoto
     * @return 
     */
    @GetMapping("/all")
    public List<Quadbike> getQuadbike(){
        return servicio.getAll();
    }
    /**
     * este mapeo orienta al llamado de un a fila de la tabla cuatrimoto
     * @param quadbikeId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int quadbikeId) {
        return servicio.getQuadbike(quadbikeId);
    }
    /**
     * este mapeo orienta al servicio de guardado de datos en la tabla cuatrimoto
     * @param quadbike
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike) {
        return servicio.save(quadbike);
    }
    /**
     * este mapeo orienta al servicio de actualizacion de datos en la tabla cuatrimoto
     * @param quadbike
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        return servicio.update(quadbike);
    }
    /**
     * este mapeo orienta al servicio de borrado de datos en la tabla cuatrimoto
     * @param quadbikeId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int quadbikeId) {
        return servicio.deleteQuadbike(quadbikeId);
    }
}
