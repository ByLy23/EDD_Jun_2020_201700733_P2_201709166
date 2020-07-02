package EDD;

import Principal.Rutas;
import EDD.ListaAdyacencia;

import Principal.Arista;

import Principal.MejorRuta;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jacky
 */
public class Grafo {

    public Vertex raiz;
    private int contador = 0;
    String[] nodoVisitado;

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
        contador++;
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
        System.out.println(contador);
    }

    public String report() {//se hace lo mismo que en mostrar
        String text = "";
        text += " rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n";
        text += "labelloc = \"t;\"label = \"REPORTE RUTAS\";\n";

        Edge auxEdge;
        Vertex auxVertex = raiz;
        while (auxVertex != null) {                                                                                                 //Mientras exista un vertice
            text += "\"" + auxVertex.nombre + "\"" + "[label = \" " + auxVertex.nombre + "\"]" + "\n";  //inicio el label                                                 //Mi auxiliar Arista es igual a mi adyacente de mi aux vertice

            System.out.print(auxVertex.nombre);
            auxEdge = auxVertex.arista;                                                                                            //imprimo el nombte de ese auxiliar vertie     
            while (auxEdge != null) {
                text += "\"" + auxVertex.nombre + "\"";
                text += "->" + "\"" + auxEdge.vertice.nombre + "\"" + "[arrowhead=normal label= \"" + auxEdge.tiempo + "\"]\n";                                                                                                //Mientras auxiliar Arista es diferente de nulo 
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

            archivo.write("digraph G {\n");
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

    ListaEnlazada<MejorRuta> lista = new ListaEnlazada<>();

    public ListaEnlazada<MejorRuta> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<MejorRuta> lista) {
        this.lista = lista;
    }

    public void generarRuta(String origen, String destino) {
        nodoVisitado = new String[contador];

        lista = new ListaEnlazada<>();
        genera(origen, destino);
        System.out.println("prueba");

    }

    int peso = 999999999;
    Vertex anterior = null;

    Pila<Arista> pila = new Pila<>();

    private void genera(String origen, String destino) {
        Vertex vertice = getVertex(origen);
        Vertex aux = null;
        boolean Encontrado = false;
        if (vertice != null) {
            // lista.insertarFinal(new MejorRuta(origen, destino, String.valueOf(vertice.arista.tiempo)));
            Edge arista = vertice.arista;
            pila.Apilar(new Arista(origen, "0"));
            while (pila != null) {
                Arista aris = pila.desapilar();
                if (aris.getNombre().equals(destino)) {
                    System.out.println("AL FIN SALIO");
                    lista.insertarFinal(new MejorRuta(origen, aris.getNombre(), aris.getTiempo()));
                    pila.limpiar();
                    break;
                } else {
                    aux = getVertex(aris.getNombre());
                    lista.insertarFinal(new MejorRuta(origen, aris.getNombre(), aris.getTiempo()));
                    if (!verificaVisitados(aux.nombre)) {
                        boolean bandera = adjuntarPilaAdyacentes(aux.nombre);
                        if (!bandera) {
                            lista.eliminar(lista.getTamanio());
                        }
                        if (contarAdyacentes(aux.nombre)) {
                            lista.eliminar(lista.getTamanio());
                        }
                    } else {
                        if (contarAdyacentes(aux.nombre)) {
                            lista.eliminar(lista.getTamanio());
                        }
                        lista.eliminar(lista.getTamanio());
                    }

                }
            }
            if (Encontrado) {
                System.out.println("No se encontro");
            }
            /*

            if(arista==null){
                verificaVisitados(vertice.nombre);
                //vertice=anterior;
            }
            Edge aux = null;

            while (arista != null) {
                if (arista.vertice.nombre.equals(destino)) {
                    verificaVisitados(destino);
                    verificaVisitados(origen);
                    peso = arista.tiempo;
                    lista.insertarFinal(new MejorRuta(origen,destino, String.valueOf(peso)));
                    break;
                } else {
                    if (!verificaVisitados(origen)) {
                        anterior=vertice;
                        if (peso >= arista.tiempo) {
                            peso = arista.tiempo;
                            aux = arista;
                             vertice = getVertex(aux.vertice.nombre);
                        }
                        if(aux==null){
                            vertice= getVertex(arista.vertice.nombre);
                        }
                    }
                }
                arista = arista.siguiente;
                    genera(vertice.nombre, destino);
            }
            if (aux != null) {
                
                //lista.insertarFinal(new MejorRuta(vertice.nombre, aux.vertice.nombre, String.valueOf(peso)));//verificar error lista
                //generarRuta(vertice.nombre, destino);

            }*/

        }
    }

    private boolean adjuntarPilaAdyacentes(String nodo) {
        boolean bandera = false;
        int cont = 0;
        Edge arista = null;
        Vertex vertice = getVertex(nodo);
        arista = vertice.arista;
        while (arista != null) {
            pila.Apilar(new Arista(arista.vertice.nombre, String.valueOf(arista.tiempo)));
            cont++;
            arista = arista.siguiente;
        }
        if (cont > 0) {
            bandera = true;
        }
        return bandera;
    }

    private boolean contarAdyacentes(String nodo) {
        boolean bandera = false;
        Vertex v = getVertex(nodo);
        Edge e = v.arista;
        while (e != null) {
            if (soloVerificar(e.vertice.nombre)) {
                bandera = true;
            } else {
                bandera = false;
            }
            e = e.siguiente;
        }
        return bandera;
    }

    public void MostrarBestRout() {

        Vertex vertice = this.raiz;
        do {

            vertice = vertice.siguiente;
        } while (vertice != raiz);
    }

    private boolean soloVerificar(String nodo) {
        boolean bandera = false;
        for (int i = 0; i < contador; i++) {
            if (nodoVisitado[i] != null) {
                if (nodoVisitado[i].equals(nodo)) {
                    bandera = true;
                    break;
                }
            }
        }
        return bandera;
    }

    private boolean verificaVisitados(String nodo) {
        boolean bandera = false;
        for (int i = 0; i < contador; i++) {
            if (nodoVisitado[i] != null) {
                if (nodoVisitado[i].equals(nodo)) {
                    bandera = true;
                    break;
                }
            }
        }
        if (!bandera) {
            for (int i = 0; i < contador; i++) {
                if (nodoVisitado[i] == null) {
                    nodoVisitado[i] = nodo;
                    break;
                }
            }
        }
        return bandera;

    }
}
