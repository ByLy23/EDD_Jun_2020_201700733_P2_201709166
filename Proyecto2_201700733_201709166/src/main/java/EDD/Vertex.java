/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author Jacky
 */
public class Vertex {
     Vertex siguiente;
     Edge arista;
     String nombre;
    
    
    public Vertex(Vertex siguiente, Edge arista, String nombre){
    this.siguiente=siguiente;
    this.arista=arista;
    this.nombre=nombre;
    }
          
}
