/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;
/**
 *
 * @author byron
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author byron
 */
public class Pila <T>{
    private NodoP<T> inicio;
    private NodoP<T> fin;
    private int tamanio=0;

    public int getTamanio() {
        return tamanio;
    }
    public Pila(){
        inicio=fin=null;
    }
    private boolean estaVacia(){
        if (tamanio==0) {
            return true;
        }
        else{
            return false;
        }
    }
    public void Apilar(T dato){
        NodoP<T> nuevo = new NodoP(dato);
        if(estaVacia()){
            inicio=fin=nuevo;
            tamanio++;
        }
        else{
        nuevo.setSiguiente(inicio);
        inicio=nuevo;
            tamanio++;
        }
    }
    public T obtenerInicio(){
        T informacion= inicio.getDato();
        return informacion;
    }
    public T desapilar(){
        T informacion= inicio.getDato();
        if (inicio==fin) {
            inicio=fin=null;
            tamanio--;
        }
        else{
            inicio= inicio.getSiguiente();
            tamanio--;
        }
        return informacion;
    }
    public void limpiar(){
        inicio=fin=null;
    }
    public String recorrerPila(){
        String iniio="digraph \"Cola\"{\n node[shape=record, width= 0.1, height= 0.1];\n";
        String cuerpo="";
        String todo="";
        NodoP<T> p=inicio;
        while(p!=null){
            System.out.print(p.getDato()+"<");
            if(p.getSiguiente()!=null)
                 cuerpo+=p.getDato()+"|";
            p= p.getSiguiente();
        }
        todo=iniio+"nodo[label= \"{"+cuerpo+"}\"];"+"}";
        return todo;
    }
    public void mostrar(){
        NodoP<T> p=inicio;
        while(p!=null){
            System.out.print(p.getDato()+"->");
            p= p.getSiguiente();
        }
        System.out.println();
    }
}
class NodoP<T>{
    private T dato;
    private NodoP siguiente;
    public NodoP(T dato){
        this.dato=dato;
        this.siguiente=null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    }
    
}
