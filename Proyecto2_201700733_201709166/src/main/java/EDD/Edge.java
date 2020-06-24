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
public class Edge {
    public Edge siguiente;
    public Vertex vertice;
    public int peso;
    
    public Edge(Edge siguiente, Vertex vertice, int peso){
        this.siguiente=siguiente;
        this.vertice=vertice;
        this.peso=peso;
               
    }
            
}
