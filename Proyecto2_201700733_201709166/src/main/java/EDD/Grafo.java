package EDD;

import Principal.Rutas;
import EDD.ListaAdyacencia;

/**
 *
 * @author Jacky
 */
public class Grafo {

    public Vertex raiz;

    public Grafo() {
        raiz = null;
    }

    public Vertex getVertex(String nombre) {
        Vertex temp = raiz;
        while (temp != null) {
            if (temp.nombre.equals(nombre)) {   //recorremos el vertice hasta encontrar 
                return temp;                    //el que se desea obtener
            }
            temp = temp.siguiente;
        }
        return null;
    }

    public void insertarEdge(Vertex lugarOrigen, Vertex lugarDestino, int peso) {
        Edge nuevo = new Edge(null, null, peso);    //es nulo porque es nuevo
        Edge aux = lugarOrigen.arista;

        if (aux == null) {
            lugarOrigen.arista = nuevo;
            nuevo.vertice = lugarDestino;
        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.vertice = lugarDestino;
        }
    }

    public void insertarVertex(String nombre) {
        Vertex nuevo = new Vertex(null, null, nombre);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Vertex aux = raiz;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }
    
     public void Mostrar() {
        Vertex auxVertice = raiz;
        Edge auxArista;
        while (auxVertice != null) {
            auxArista = auxVertice.arista;
            System.out.print(auxVertice.nombre);
            while (auxArista != null) {
                System.out.print("->" + auxArista.vertice.nombre);
                auxArista = auxArista.siguiente;
            }
            auxVertice = auxVertice.siguiente;
            System.out.println("");
        }
    }

}
