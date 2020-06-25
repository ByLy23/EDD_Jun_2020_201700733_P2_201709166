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
    public void Insertar(Vehiculo carro){
        insertarNodo(raiz, carro);
    }
    private void insertarNodo(PaginaB raiz, Vehiculo carro){
        this.bandera=false;
        this.medio=null;
        this.nuevo=null;
        PaginaB aux=null;
        empujar(raiz,carro ,this.bandera,this.medio,nuevo);
        if(this.bandera){
            aux= new PaginaB();
            aux.setContador(1);
            aux.getCarro()[1]= this.medio;
            aux.getPaginas()[0]= raiz;
            aux.getPaginas()[1]= this.nuevo;
            this.raiz=aux;
        }
    }
    private void empujar(PaginaB raiz, Vehiculo carro, boolean bandera, Vehiculo media, PaginaB aux){
        if(raiz==null){
            this.bandera=true;
            this.medio=carro;
            this.nuevo=null;
        }else{
            boolean busqueda= busquedaIterativa(raiz, carro, this.iterador);
            if(busqueda)
            {
                this.bandera=false;
                return;
            }
            empujar(raiz.getPaginas()[this.iterador], carro,this.bandera, this.medio, this.nuevo);
            if(this.bandera){
                if(raiz.Lleno(raiz)){
                    this.iterador=0;
                    boolean busquedap= busquedaIterativa(raiz, carro, this.iterador);
                    dividirPagina(raiz,this.medio,this.nuevo,this.iterador,this.medio,this.nuevo);
                }else{
                    this.bandera=false;
                    boolean busquedap=busquedaIterativa(raiz, carro, this.iterador);
                    insertarHoja(raiz,this.medio,this.nuevo,this.iterador);
                }
            }
        }
    }
    private void dividirPagina(PaginaB aux, Vehiculo carro, PaginaB aux2, int k, Vehiculo carr, PaginaB nuevo){
        int n, posicionMedia;
        if(this.iterador<=2)
            posicionMedia=2;
        else
            posicionMedia=3;
        this.nuevo= new PaginaB();
        for (n = posicionMedia + 1 ; n<5; n++) {
            this.nuevo.getCarro()[n-posicionMedia]=aux.getCarro()[n];
            this.nuevo.getPaginas()[n-posicionMedia]=aux.getPaginas()[n];
            aux.getCarro()[n]=null;
            aux.getPaginas()[n]=null;
        }
        this.nuevo.setContador(4-posicionMedia);
        aux.setContador(posicionMedia);
        if(this.iterador<=2)
            insertarHoja(aux,carro,aux2,this.iterador);
        else
            insertarHoja(this.nuevo,carro,aux2,this.iterador-posicionMedia);
        this.medio=aux.getCarro()[aux.getContador()];
        this.nuevo.getPaginas()[0]=aux.getPaginas()[aux.getContador()];
        aux.getCarro()[aux.getContador()]=null;
        aux.getPaginas()[aux.getContador()]=null;
        aux.setContador(aux.getContador()-1);
    }
    private void insertarHoja(PaginaB aux, Vehiculo carro, PaginaB nuevo, int k){
        int cont;
        for (cont = aux.getContador();cont  >= k+1; cont--) {
            aux.getCarro()[cont+1]=aux.getCarro()[cont];
            aux.getPaginas()[cont+1]=aux.getPaginas()[cont];
        }
        aux.getCarro()[k+1]=carro;
        aux.getPaginas()[k+1]=nuevo;
        aux.setContador(aux.getContador()+1);
        //ordenamiento burbuja
        for (int n = 1; n <aux.getContador()-1; n++) {
            for (int m = 1; m < aux.getContador()-1; m++) {
                if(aux.getCarro()[m].getPlaca().compareTo(aux.getCarro()[m+1].getPlaca())>0){
                    Vehiculo cars= aux.getCarro()[m];
                    aux.getCarro()[m+1]=aux.getCarro()[m];
                    aux.getCarro()[m]=cars;
                }
            }
        }
    }
    private boolean busquedaIterativa(PaginaB aux, Vehiculo carro, int k){
        boolean bandera= false;
        if(carro.getPlaca().compareTo(aux.getCarro()[1].getPlaca())<0){
            bandera=false;
            this.iterador=0;
        }else{
            this.iterador=aux.getContador();
            while(carro.getPlaca().compareTo(aux.getCarro()[this.iterador].getPlaca())<0 && this.iterador>1){
                this.iterador--;
            }
            bandera = carro.getPlaca().compareTo(aux.getCarro()[this.iterador].getPlaca())==0;
        }return bandera;
    }
}
