package Domingo_Reto3.Reto3.controller;

import Domingo_Reto3.Reto3.service.ServiciosCliente;
import Domingo_Reto3.Reto3.model.Cliente;
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
 * clase controlador cliente escucha los llamados en la paguina para orientar 
 * las acciones que realizaran los servicios y los metodos crud en las tablas 
 * @author Andres Diaz
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorCliente {
    
    @Autowired
    private ServiciosCliente servicio;
    /**
     * este mapeo orienta al llamado de todos los elementos contenidos en la tabla cliente
     * @return 
     */  
    @GetMapping("/all")
    public List<Cliente> getClients(){
        return servicio.getAll();
    }
    /**
     * este mapeo orienta al llamado de un a fila de la tabla cliente
     * @param clientId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return servicio.getClient(clientId);
    }
    /**
     * este mapeo orienta al servicio de guardado de datos en la tabla categoria
     * @param client
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return servicio.save(client);
    }
    /**
     * este mapeo orienta al servicio de actualizacion de datos en la tabla cliente
     * @param client
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente client) {
        return servicio.update(client);
    }
    /**
     * este mapeo orienta al servicio de borrado de datos en la tabla cliente
     * @param clientId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicio.deleteClient(clientId);
    }
}
