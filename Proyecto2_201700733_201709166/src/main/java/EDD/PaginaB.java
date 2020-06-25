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
        
    }
}
