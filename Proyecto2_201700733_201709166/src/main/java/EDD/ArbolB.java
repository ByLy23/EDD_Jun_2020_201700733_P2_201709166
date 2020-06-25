/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Vehiculo;

/**
 *
 * @author byron
 */
public class ArbolB {
    private PaginaB raiz;
    private boolean bandera;
    private Vehiculo medio=null;
    private PaginaB nuevo;
    private PaginaB busqueda=null;
    private int iterador;
    public ArbolB()
    {
        raiz=null;
        bandera=false;
        medio= new Vehiculo();
        nuevo=null;
        iterador=0;
    }
    public PaginaB buscarCarro(String placa){
        buscaCarro(raiz, placa);
        PaginaB nuevaB= busqueda;
        return nuevaB;
    }
    private void buscaCarro(PaginaB raiz, String placa){
        if(raiz!=null){
        for (int i = 0; i < raiz.getContador(); i++) {
            if(raiz.getCarro()[i].getPlaca().compareTo(placa)==0){
                busqueda=raiz;
            }
        }
        for (PaginaB pagina : raiz.getPaginas()) {
           if (pagina != null) {
                buscaCarro(pagina, placa);
            }
        }
            
            }
    }
}
