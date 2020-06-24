/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EDD.Grafo;
import EDD.ListaCircularDoble;
import Interfaz.FirstStep;

/**
 *
 * @author byron
 */
public class Inicio {
    
    public static ListaCircularDoble lcd;
    public static Principal.Conductores condu;
    public static EDD.Grafo graph; 
    
 public static void main(String[] args) {
        

        FirstStep home;
        home = new FirstStep();
        home.setVisible(true);
        lcd=new ListaCircularDoble();
        graph=new Grafo();
    }
}
