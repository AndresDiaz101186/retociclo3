package Domingo_Reto3.Reto3.controller;

import Domingo_Reto3.Reto3.service.ServiciosMensaje;
import Domingo_Reto3.Reto3.model.Mensaje;
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
 * escucha los llamados en la paguina para orientar 
 * las acciones que realizaran los servicios y los metodos crud en las tablas 
 * @author Andres Diaz
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorMensaje {
    @Autowired
    private ServiciosMensaje servico;
    /**
     * este mapeo orienta al llamado de todos los elementos contenidos en la tabla mensaje
     * @return 
     */
    @GetMapping("/all")
    public List<Mensaje> getMessages(){
        return servico.getAll();
    }
    /**
     * este mapeo orienta al llamado de un a fila de la tabla mensaje
     * @param messageId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Mensaje> getMessage(@PathVariable("id") int messageId) {
        return servico.getMessage(messageId);
    }
    /**
     * este mapeo orienta al servicio de guardado de datos en la tabla mensaje
     * @param message
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return servico.save(message);
    }
    /**
     * este mapeo orienta al servicio de actualizacion de datos en la tabla mensaje
     * @param message
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return servico.update(message);
    }
    /**
     * este mapeo orienta al servicio de borrado de datos en la tabla mensaje
     * @param messageId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servico.deleteMessage(messageId);
    }
}