/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Vehiculo;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author byron
 */
public class ArbolB {
    private PaginaB raiz=null;
    private boolean bandera=false;
    private Vehiculo medio=null;
    private PaginaB nuevo=null;
    private PaginaB busqueda=null;
    private Vehiculo carros;

    public Vehiculo getCarros() {
        return carros;
    }

    public void setCarros(Vehiculo carros) {
        this.carros = carros;
    }
    
    private int iterador=0;
    

    public PaginaB getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(PaginaB busqueda) {
        this.busqueda = busqueda;
    }
    public ArbolB()
    {
        medio= new Vehiculo();
    }
    public PaginaB buscarCarro(String placa){//metodo publico para buscar, nada mas necesita la placa
        buscaCarro(raiz, placa);//aca adentro va la busqueda del carro es recursiva por lo que...
        PaginaB nuevaB= busqueda;//aqui se crea una nueva pagina la cual va a tener la informacion de busqueda...
        return nuevaB;//que tambien es una pagina general para busquedas
    }
    private void buscaCarro(PaginaB raiz, String placa){
        if(raiz!=null){//busca en cada posicion del arreglo de cada nodo, si es nula lo obvia de lo contrario ingresa al metodo
        for (int i = 0; i <= raiz.getContador(); i++) {
            if(raiz.getCarro()[i].getPlaca().compareTo(placa)==0){//compara las placas para igualar
                busqueda=raiz;
                setCarros(raiz.getCarro()[i]);
                
            }
        }
        for (PaginaB pagina : raiz.getPaginas()) {//este es un foreach de la coleccion, en este caso en la coleccion de paginas
           if (pagina != null) {//esto verifica si cada pagina o rama es vacia
                buscaCarro(pagina, placa);//aca llega lo recursivo para que baje al siguiente nodo, o a la siguiente pagina
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
        empujar(raiz,carro);
        if(this.bandera){
            aux= new PaginaB();
            aux.setContador(1);
            aux.getCarro()[1]= this.medio;
            aux.getPaginas()[0]= raiz;
            aux.getPaginas()[1]= this.nuevo;
            this.raiz=aux;
        }
    }
    private void empujar(PaginaB raiz, Vehiculo carro){
        if(raiz==null){
            this.bandera=true;
            this.medio=carro;
            this.nuevo=null;
        }else{
            boolean busqueda= busquedaIterativa(raiz, carro);
            if(busqueda)
            {
                this.bandera=false;
                return;
            }
            empujar(raiz.getPaginas()[this.iterador], carro);
            if(this.bandera){
                if(raiz.Lleno(raiz)){
                    this.iterador=0;
                    boolean busquedap= busquedaIterativa(raiz, carro);
                    dividirPagina(raiz,this.medio,this.nuevo);
                }else{
                    this.bandera=false;
                    boolean busquedap=busquedaIterativa(raiz, carro);
                    insertarHoja(raiz,this.medio,this.nuevo,this.iterador);
                }
            }
        }
    }
    private void dividirPagina(PaginaB aux, Vehiculo carro, PaginaB aux2){
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
    private boolean busquedaIterativa(PaginaB aux, Vehiculo carro){
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
    public void mostrar(){
        
    }
    private void mostrarB(StringBuilder dato) throws Exception{
            String mensaje="digraph Btree{ \n  node[shape=record, style=filled,fillcolor=khaki, color =sienna , fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n labelloc = \"t;\"label = \"REPORTE CONDUCTORES\";"+dato+"\n  }";
            FileWriter file= new FileWriter("bTree.dot");
            PrintWriter impresion= new PrintWriter(file);
            impresion.println(mensaje);
            file.close();
            String comando= "dot -Tjpg bTree.dot -o bTree.jpg -Gcharset=latin1";
            Runtime rt= Runtime.getRuntime();
            rt.exec(comando);
        }
    StringBuilder b= new StringBuilder();
    public void imprimirNodo() throws Exception{
        b.setLength(0);
        imprimirRaiz(raiz);
    }
    
    
    
     private void imprimirRaiz(PaginaB raiz) throws Exception{
            if(raiz!=null){
                 b.append("Nodo"+raiz.hashCode());
        b.append("[label=\"<P0>");
    for (int i = 1; i <= raiz.getContador(); i++) {
       b.append("|Placa: "+ raiz.getCarro()[i].getPlaca()+"\\nMarca: "+raiz.getCarro()[i].getMarca()+"\\nModelo: "+raiz.getCarro()[i].getModelo()+"\\nColor: "+raiz.getCarro()[i].getColor()+"\\nAnio: "+raiz.getCarro()[i].getAnio()+"\\nTransmision: "+raiz.getCarro()[i].getTransmision());
       b.append("|<P"+(i)+">");
    }
    b.append("\"];\n");
                for (int i = 0; i < raiz.getPaginas().length; i++) {
                    if(raiz.getPaginas()[i]!=null){
                 imprimirRaiz(raiz.getPaginas()[i]);
                b.append("Nodo"+raiz.hashCode()+":P"+i+"->"+"Nodo"+raiz.getPaginas()[i].hashCode()+";\n");
                    }
    }
            System.out.println(b);
            mostrarB(b);
        }
     }
     public void modificarDatos(Vehiculo carro){
         modificarDatos(raiz, carro);
     }
     private void modificarDatos(PaginaB raiz, Vehiculo carro){
         if(raiz!=null){
             for (int i = 0; i <= raiz.getContador(); i++) {
                 if(raiz.getCarro()[i].getPlaca().compareTo(carro.getPlaca())==0){
                     raiz.getCarro()[i]=carro;
                 }
             }
             for (int i = 0; i < raiz.getPaginas().length; i++) {
                 if(raiz.getPaginas()[i]!=null){
                     modificarDatos(raiz.getPaginas()[i],carro);
                 }
             }
         }
     }
     public void cargaMasiva(String datos){
         String[] saltoLinea= datos.split(";");
         Vehiculo aux;
        for (String saltoLinea1 : saltoLinea) {
            String[] lectura = saltoLinea1.split(":");
            aux= new Vehiculo(lectura[0], lectura[1],lectura[2],Integer.parseInt(lectura[3]),lectura[4],Integer.parseInt(lectura[5]), lectura[6]);
            Insertar(aux);
        }
     }
}
