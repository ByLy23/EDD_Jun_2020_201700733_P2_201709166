/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EDD.ArbolB;
import EDD.ListaCircularDoble;
import EDD.TablaHash;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jacky
 */
public class Viajes {

    TablaHash pointerCliente;
    ListaCircularDoble pointerConductor;
    ArbolB pointerVehiculos;
    String llaveViaje;

     public String generaLlaves(String placa)
    {
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm")).trim().replace(" ", "").toUpperCase(); //quita espacio y transforma a mayuscula
    
        System.out.println("Fecha hora: " + placa + FechaHora);
        return placa + FechaHora;
    }

    public String getLlaveViaje() {
        return llaveViaje;
    }

    public void setLlaveViaje(String llaveViaje) {
        this.llaveViaje = llaveViaje;
    }
     
    public Viajes(String placa, TablaHash pointerCliente, ListaCircularDoble pointerConductor, ArbolB pointerVehiculos) {
        this.llaveViaje=generaLlaves(placa);
        this.pointerCliente=pointerCliente;
        this.pointerConductor=pointerConductor;
        this.pointerVehiculos=pointerVehiculos;
 
    }

   
    
    

}
