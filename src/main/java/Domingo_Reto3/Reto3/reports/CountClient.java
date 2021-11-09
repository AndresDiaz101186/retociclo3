package Domingo_Reto3.Reto3.reports;

import Domingo_Reto3.Reto3.model.Cliente;
/**
 * clase countClient
 * @author Andres Diaz
 */
public class CountClient {
    private Long total;
    private Cliente client;
    /**
     * creacion de parametros de cliente y total clientes
     * @param total
     * @param client 
     */
    public CountClient(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    /**
     * retorna total
     * @return 
     */
    public Long getTotal() {
        return total;
    }
    /**
     * igresa valores en totol
     * @param total 
     */
    public void setTotal(Long total) {
        this.total = total;
    }
    /**
     * llama lo que hay en cliente
     * @return 
     */
    public Cliente getClient() {
        return client;
    }
    /**
     * ingresa valor en client
     * @param client 
     */
    public void setClient(Cliente client) {
        this.client = client;
    }
}
