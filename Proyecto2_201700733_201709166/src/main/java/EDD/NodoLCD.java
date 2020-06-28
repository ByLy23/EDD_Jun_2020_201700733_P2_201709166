/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Conductores;

public class NodoLCD {

    public Conductores getDato() {
        return dato;
    }

    public void setDato(Conductores dato) {
        this.dato = dato;
    }

    public NodoLCD getNext() {
        return next;
    }

    public void setNext(NodoLCD next) {
        this.next = next;
    }

    public NodoLCD getBefore() {
        return before;
    }

    public void setBefore(NodoLCD before) {
        this.before = before;
    }

    public NodoLCD() {
        next=null;
        before=null;
    }
    Conductores dato;
    NodoLCD next;
    NodoLCD before;   
    
   
    
}
