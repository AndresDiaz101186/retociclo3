/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Domingo_Reto3.Reto3.interfaces;

import Domingo_Reto3.Reto3.model.Reservaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;
/**
 * interfase de reservaciones para los metodos crud
 * @author Andres Diaz
 */
public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer> {
    public List<Reservaciones> findAllByStatus(String status);
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore (Date dateOne,Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]>   countTotalReservationByClient ();

}

