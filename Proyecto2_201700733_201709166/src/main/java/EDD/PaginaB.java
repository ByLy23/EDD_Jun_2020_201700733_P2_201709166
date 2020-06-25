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
public class PaginaB {
    private int contador;
    private Vehiculo carros[];//estos son los datos
    private PaginaB paginas[];//estas son las claves que va a tener 
    private int tamPagina;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Vehiculo[] getCarro() {
        return carros;
    }

    public void setCarro(Vehiculo[] carro) {
        this.carros = carro;
    }

    public PaginaB[] getPaginas() {
        return paginas;
    }

    public void setPaginas(PaginaB[] paginas) {
        this.paginas = paginas;
    }
    public PaginaB(){
        this.carros= new Vehiculo[5];
        for (int i = 0; i < 5; i++) {
            this.carros[i]= new Vehiculo();
        }
        contador=0;
        paginas=new PaginaB[5];
    }
    public boolean Lleno(PaginaB pagina){
            return (pagina.getContador()==4);
        }
    public int verClave(String placa){
        for (int i = 0; i < contador; i++) {
            if(carros[i].getPlaca().compareTo(placa)==0)return i;
        }
        return -1;
    }
}
