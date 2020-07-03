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
public class ViajeConductor {

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
 String nombre;
 int cantidad;

    public ViajeConductor(String nombre) {
        this.nombre = nombre;
        cantidad=0;
    }
    public void sumar(){
        cantidad+=1;
    }
    public ViajeConductor(){
        this.nombre="";
        this.cantidad=0;
    }
}