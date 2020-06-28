/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Rutas;
import Principal.Viajes;

/**
 *
 * @author Jacky
 */
public class NodoLS {
    public Viajes viaje;
    public NodoLS next;
    public NodoLS prev;
    
    public NodoLS(Viajes viajecito){
    this.viaje=viajecito;
    this.next=null;
    this.prev=null;
    }

}
