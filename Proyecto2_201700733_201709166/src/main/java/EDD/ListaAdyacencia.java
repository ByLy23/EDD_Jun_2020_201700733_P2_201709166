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
public class ListaAdyacencia {

    class Nodo {

        Nodo siguiente;
        Rutas ruta;

        public Nodo(Rutas ruta) {
            this.ruta = ruta;
            siguiente = null;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Rutas getRuta() {
            return ruta;
        }

        public void setRuta(Rutas ruta) {
            this.ruta = ruta;
        }
    }

    private Nodo inicio;
    private Nodo fin;
    private int tam;

    public ListaAdyacencia() {
        this.inicio = null;
        this.fin = null;
        this.tam = 0;
    }
     public ListaAdyacencia(Rutas ruta) {
        this.inicio = inicio;
        this.fin = fin;
        this.tam = 0;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void insertarFinal(Rutas ruta) {
        Nodo nuevo = new Nodo(ruta);
        if (isEmpty()) {
            inicio = fin = nuevo;
            tam++;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            tam++;
        }
    }

    public void insertarInicio(Rutas ruta) {
        Nodo nuevo = new Nodo(ruta);
        if (isEmpty()) {
            inicio = fin = nuevo;
            tam++;
        } else {
            nuevo.setSiguiente(nuevo);
            inicio = nuevo;
            tam++;
        }
    }

    public void insertar(Rutas ruta, int index) {
        Nodo nuevo = new Nodo(ruta);
        if (isEmpty()) {
            inicio = fin = nuevo;
            tam++;
        } else if (index==tam) {
            insertarFinal(ruta);
        }else if(index==0){
            insertarInicio(ruta);
        } else {
            Nodo aux= inicio;
            int x=0;
            while(aux!=null){
                if(x==index){
                    break;
                }
                aux= aux.getSiguiente();
            }
            Nodo sig= aux.getSiguiente();
            aux.setSiguiente(nuevo);
            nuevo.setSiguiente(sig);
            tam++;
        }
    }
    
   
            
           
}
