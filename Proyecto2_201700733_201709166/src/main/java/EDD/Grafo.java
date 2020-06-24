
package EDD;

import Principal.Rutas;
import EDD.ListaAdyacencia;

/**
 *
 * @author Jacky
 */
public class Grafo {
    private String principal;
  ListaAdyacencia hola=new ListaAdyacencia();

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public ListaAdyacencia getHola() {
        return hola;
    }

    public void setHola(ListaAdyacencia hola) {
        this.hola = hola;
    }
  
    public Grafo(String principal,ListaAdyacencia hola ){
        this.principal=principal;
        this.hola=hola;
    }
    
}
