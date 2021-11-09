package Domingo_Reto3.Reto3.controller;

import Domingo_Reto3.Reto3.reports.CountClient;
import Domingo_Reto3.Reto3.reports.ReservationStatus;
import Domingo_Reto3.Reto3.service.ServiciosReservaciones;
import Domingo_Reto3.Reto3.model.Reservaciones;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorReservaciones {
   
    @Autowired
    private ServiciosReservaciones servicio;
    /**
     * este mapeo orienta al llamado de todos los elementos contenidos en la tabla reservaciones
     * @return 
     */
    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
        return servicio.getAll();
    }
    /**
     * este mapeo orienta al llamado de un a fila de la tabla reservaciones
     * @param reservationId
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    /**
     * este mapeo orienta al servicio de guardado de datos en la tabla reservaciones
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }
    /**
     * este mapeo orienta al servicio de actualizacion de datos en la tabla reservaciones
     * @param reservation
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio.update(reservation);
    }
    /**
     * este mapeo orienta al servicio de borrado de datos en la tabla reservaciones
     * @param reservationId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }
    /**
     * este mapeo orienta el servicio a presentar el estado del reporte.
     * @return 
     */
    @GetMapping("/report-status")
    public ReservationStatus getReservationsStatusReport(){
        return servicio.getReservationStatusReport();
    }
    /**
     * con ete mapeo toma las fechas para presentar el reporte
     * @param dateOne
     * @param dateTwo
     * @return 
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservationReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return servicio.getReservationPeriod(dateOne,dateTwo);
    }
    /**
     * este mapeo presenta la cantidad de clientes segun sea el caso.
     * @return 
     */
    @GetMapping("/report-clients")
    public List<CountClient> getClient(){
        return servicio.getTopClients();
    }
}

