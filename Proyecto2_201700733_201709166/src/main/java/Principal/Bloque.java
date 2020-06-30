/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author byron
 */
public class Bloque {

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conductores getConductor() {
        return conductor;
    }

    public void setConductor(Conductores conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Bloque(String lugarOrigen, String lugarDestino, String FechaHora, Cliente cliente, Conductores conductor, Vehiculo vehiculo, String llave) {
        this.lugarDestino = lugarDestino;
        this.lugarOrigen = lugarOrigen;
        this.FechaHora = FechaHora;
        this.cliente = cliente;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.llave = llave;
    }
    String lugarDestino;
    String lugarOrigen;
    String FechaHora;
    Cliente cliente;
    Conductores conductor;
    Vehiculo vehiculo;
    String llave;
    public Bloque(){
        
    }
}
