package Domingo_Reto3.Reto3.service;

import Domingo_Reto3.Reto3.repository.RepositorioMensaje;
import Domingo_Reto3.Reto3.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * clase servicio mensajes
 * trabaja las llamadas, entradas, actualizaciones y borrado en conjunto con los metodos crud
 * @author Andres Diaz
 */
@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;
    /**
     * lista todos los elementos contenidos en la tabla mensajes
     * @return 
     */
    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * encuentra una fila espesifica de la tabla mensajes
     * @param messageId
     * @return 
     */
    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    /**
     * verifica el id y le otorga una a la entrada para ser almacenada en la tabla 
     * @param message
     * @return 
     */
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    /**
     * este metodo ubica una fila en la tabla para ser modificada
     * @param message
     * @return 
     */
    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    /**
     * este metodo recibe un id para ubicar la fila de la tabla y eliminarla
     * @param messageId
     * @return 
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
