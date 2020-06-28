/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Rutas;

/**
 *
 * @author Jacky
 */
public class NodoLS {
    private Rutas bestruta;
    private NodoLS enlace;
    
    public NodoLS(Rutas mejorR){
    this.bestruta=mejorR;
    this.enlace=null;
    }

    public Rutas getBestruta() {
        return bestruta;
    }

    public void setBestruta(Rutas bestruta) {
        this.bestruta = bestruta;
    }

    public NodoLS getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoLS enlace) {
        this.enlace = enlace;
    }
    
}
