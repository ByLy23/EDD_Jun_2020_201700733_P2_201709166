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
public class ViajeVehiculo {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ViajeVehiculo(String nombre) {
        this.nombre = nombre;
        cantidad=0;
    }

    public ViajeVehiculo() {
        cantidad=0;
        nombre="";
    }
    public void sumar(){
        cantidad+=1;
    }
    String nombre;
    int cantidad;
}
