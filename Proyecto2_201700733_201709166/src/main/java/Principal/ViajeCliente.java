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
public class ViajeCliente {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    public void sumar(){
        tiempo+=1;
    }
    public ViajeCliente(){
        tiempo=0;
        nombre="";
    }
    public ViajeCliente(String nombre){
        tiempo=0;
        this.nombre=nombre;
    }
    String nombre;
    int tiempo;
}
