package Domingo_Reto3.Reto3.reports;
/**
 * creacion de el estado de la reservacion
 * @author Andres Diaz
 */
public class ReservationStatus {
    private Integer completed;
    private Integer cancelled;
    /**
     * estados de la reserva
     * @param completed
     * @param cancelled 
     */
    public ReservationStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    /**
     * se invoca si a reserva ha sido completada
     * @return 
     */
    public Integer getCompleted() {
        return completed;
    }
    /**
     * se establese si la reserva se completo
     * @param completed 
     */
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }
    /**
     * se invoca si la reserva fue cancelada
     * @return 
     */
    public Integer getCancelled() {
        return cancelled;
    }
    /**
     * se establece si la reserva se cancela
     * @param cancelled 
     */
    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
