/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Domingo_Reto3.Reto3.interfaces;

import Domingo_Reto3.Reto3.model.Quadbike;
import org.springframework.data.repository.CrudRepository;

/**
 * interfase de cuatrimoto para los metodos crud
 * @author Andres Diaz
 */
public interface InterfaceQuadbike extends CrudRepository<Quadbike,Integer> {
    
}
