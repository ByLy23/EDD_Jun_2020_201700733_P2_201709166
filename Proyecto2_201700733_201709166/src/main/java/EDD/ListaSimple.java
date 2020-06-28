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


public class ListaSimple {
    private NodoLS primero;
    private NodoLS ultimo;
    
    public ListaSimple(){
    this.primero=null;
    this.ultimo=null;
    }
    
       public void insertarInicio(Rutas dato){
        NodoLS nuevo;
        nuevo = new NodoLS(dato);
        if(primero==null){
            primero=nuevo;
            ultimo=nuevo;
        }else{ 
            nuevo.setEnlace(primero);
            primero=nuevo;
        }
    }
    
    public void insertarFinal(Rutas dato){ 
        NodoLS nuevo;
        nuevo = new NodoLS(dato);
        if(primero==null){
            primero=nuevo;
            ultimo=nuevo;
        }else{ 
            ultimo.setEnlace(nuevo);
            ultimo=nuevo;
            ultimo.setEnlace(null);
        }      
    }
    
    public boolean  esVacia(){
        return (primero==null);
    }
    
    public boolean buscarNodo(Rutas dato){
        boolean encontro=false;
        NodoLS p=primero;
        
       /* while (p.getEnlace()!=null && encontro==false){
            if(p.getBestruta()==dato){
                encontro = true;
                p=p.getEnlace();  
            }  
        }*/
        return encontro;
    } 
    
    
    public boolean borrarNodoInicio(){
        if(esVacia()){
            return false;
        }
            if(primero.getEnlace()==null){
                primero=null;
                ultimo=null;
                return false;
            }else {
                NodoLS temp=primero;
                primero=primero.getEnlace();
                temp.setEnlace(null);
                return true;
            }
        }

   

}
