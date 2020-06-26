package EDD;

import Principal.Rutas;
import EDD.ListaAdyacencia;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jacky
 */
public class Grafo {

    public Vertex raiz;

    public Grafo() {
        raiz = null;
    }

    public void insertarEdge(Vertex lugarOrigen, Vertex lugarDestino, int peso) {
        Edge nuevo = new Edge(null, null, peso);    //es nulo porque en la arista no podes guardar origenes ni destino, solo me importa el peso
        Edge aux = lugarOrigen.arista;              //el auxiliar es igual al adyacente del vertice de origen

        if (aux != null) {                          //Si el auxiliar es diferente de nulo
            while (aux.siguiente != null) {         //vamos a recorrer hasta encontrar el destino de dicho vertice
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;                  //cuando lo encuentra lo asigna como nuevo origen
            nuevo.vertice = lugarDestino;           //y al adyacente del nuevo es el destino
        } else {                                    //Si el auxiliar es igual a nulo
            lugarOrigen.arista = nuevo;             //inserto la nueva arista apuntando a el adyacente del origen
            nuevo.vertice = lugarDestino;           //y el adyacente del nuevo es el destino
        }
    }

    public Vertex getVertex(String nombre) {    //Aqui verificamos si ya existe x vertice
        Vertex temp = raiz;                     //creo un temporal con la raiz
        while (temp != null) {                  //meintras el temporal sea diferente de nulo, es decir exista x vertice
            if (temp.nombre.equals(nombre)) {   //si el nodo raiz es igual al nombre que inserte sea origen o destino
                return temp;                    //retorna el temporal
            }
            temp = temp.siguiente;              //sino sigue recorriendo
        }
        return null;                            //y obvio sino halla nada es nulo 
    }

    public void insertarVertex(String nombre) {
        Vertex nuevo = new Vertex(null, null, nombre);  //creo un vertice nuevo donde solo me importa saber el nombre

        if (raiz != null) {                         //si la raiz es diferente de nulo 
            Vertex temp = raiz;                     //creo un nodo temporal donde asigno la raiz
            while (temp.siguiente != null) {        //mientras el siguiente de la raiz es diferente de nulo
                temp = temp.siguiente;              //recorro hasta encontrar el temporal
            }
            temp.siguiente = nuevo;                 //el siguiente de la raiz es nuevo
        } else {                                    //si la raiz es nulo
            raiz = nuevo;                           //raiz es igual a nuevo
        }
    }

    public void Mostrar() {
        Edge auxEdge;
        Vertex auxVertex = raiz;

        while (auxVertex != null) {                            //Mientras exista un vertice
            auxEdge = auxVertex.arista;                        //Mi auxiliar Arista es igual a mi adyacente de mi aux vertice
            System.out.print(auxVertex.nombre);                //imprimo el nombte de ese auxiliar vertie     
            while (auxEdge != null) {                          //Mientras auxiliar Arista es diferente de nulo 
                System.out.print("->" + auxEdge.vertice.nombre);//Imprimo el adyacente de dicho auxiliar
                auxEdge = auxEdge.siguiente;                    //E imprimo los siguientes de dicho adyacente
            }                                                   //Hasta que ya no tenga adyacentes y salgo del while porque seria igual a nulo
            auxVertex = auxVertex.siguiente;                    //Repito el proceso para mi siguiente verti
            System.out.println("\n");
        }
    }

    public String report() {//se hace lo mismo que en mostrar
        String text = "";
        Edge auxEdge;
        Vertex auxVertex = raiz;
        while (auxVertex != null) {                                                                                                 //Mientras exista un vertice
             text+="\""+auxVertex.nombre+"\""+ "[label = \" "+auxVertex.nombre+"\"]"+"\n";  //inicio el label                                                 //Mi auxiliar Arista es igual a mi adyacente de mi aux vertice
             
             System.out.print(auxVertex.nombre); 
             auxEdge = auxVertex.arista;                                                                                            //imprimo el nombte de ese auxiliar vertie     
            while (auxEdge != null) {
                text+="\""+auxVertex.nombre+"\"";  
                text+="->"+"\""+auxEdge.vertice.nombre+"\""+"[arrowhead=normal label= \""+ auxEdge.tiempo+"\"]\n";                                                                                                //Mientras auxiliar Arista es diferente de nulo 
                System.out.print("->" + auxEdge.vertice.nombre);                                                                    //Imprimo el adyacente de dicho auxiliar
                auxEdge = auxEdge.siguiente;                                                                                        //E imprimo los siguientes de dicho adyacente
            }                                                                                                                       //Hasta que ya no tenga adyacentes y salgo del while porque seria igual a nulo
            auxVertex = auxVertex.siguiente;                                                                                        //Repito el proceso para mi siguiente verti
        }
        
        return text;
    }

    public void Graficar() {
        try {
            FileWriter archivo = new FileWriter("ReporteRutas.dot");
            archivo.write("digraph G {" + "\n rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n" );
            archivo.write("labelloc = \"t;\"label = \"REPORTE RUTAS\";\n");
            //CONTENIDO
            archivo.write(report());

            archivo.write("\n}");
            archivo.close();
            // archivo.write(contadorUsuarios + ";\n}");

            String abrir = "dot -Tpng " + "ReporteRutas" + ".dot -o " + "ReporteRutas" + ".png";
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec(abrir);
            archivo.close();
            System.out.println("REPORTE DE RUTAS CREADO");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}