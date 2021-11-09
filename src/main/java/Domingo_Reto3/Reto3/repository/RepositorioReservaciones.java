package Domingo_Reto3.Reto3.repository;

import Domingo_Reto3.Reto3.interfaces.InterfaceReservaciones;
import Domingo_Reto3.Reto3.model.Cliente;
import Domingo_Reto3.Reto3.model.Reservaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Domingo_Reto3.Reto3.reports.CountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio reservaciones
 * @author Andres Diaz
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud4;
    /**
     * devuelve todo lo contenido en la tabla reservaciones
     * @return 
     */   
    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    /**
     * encuentra un elemento espesifico de reservaciones por el id
     * @param id
     * @return 
     */
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    /**
     * guarda datos en la tabla reservaciones
     * @param reservation
     * @return 
     */
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    /**
     * borra elementos de la tabla reservaciones
     * @param reservation 
     */
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
    /**
     * llama las reservaciones segun su estado
     * @param status
     * @return 
     */
    public List<Reservaciones> getReservationByStatus(String status){
        return crud4.findAllByStatus(status);
    }
    /**
     * crea una lista de las reservaciones segun las fechas
     * @param dateOne
     * @param dateTwo
     * @return 
     */
    public List<Reservaciones> getReservationPeriod(Date dateOne, Date dateTwo){
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    /**
     * metodo que devuelve el cliente con mas reservas
     * @return 
     */
    public List<CountClient> getTopClient(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            clientList.add(new CountClient((Long) report.get(i)[1] ,(Cliente)report.get(i)[0]));
        }
        return clientList;
    }
}
