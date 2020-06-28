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
public class ListaSimple {

    TablaHash clientes;
    ListaCircularDoble conductor;
    ArbolB vehiculos;
    NodoLS raiz;

    public ListaSimple() {
        this.raiz = null;
    }

    public void InsertarViaje(String placa) {
        Viajes viajecito = new Viajes(placa, clientes, conductor, vehiculos);
        NodoLS nodoBlockChain = new NodoLS(viajecito);
        if (raiz == null) {
            raiz = nodoBlockChain;
        } else {
            NodoLS aux = raiz;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nodoBlockChain;
            nodoBlockChain.prev = aux;
        }
    }
    
    public void Mostrar(){
        NodoLS actual =raiz;
        
        while(actual!=null){
            System.out.println(actual.viaje.getLlaveViaje()+"->");
            actual=actual.next;
        }
    }
}
