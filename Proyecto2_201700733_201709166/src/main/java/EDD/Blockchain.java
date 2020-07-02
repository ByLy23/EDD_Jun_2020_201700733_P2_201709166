/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Bloque;
import Principal.Cliente;
import Principal.Conductores;
import Principal.Inicio;
import Principal.MejorRuta;
import Principal.Rutas;
import Principal.Vehiculo;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author byron
 */
public class Blockchain {

    ListaEnlazada<Bloque> listabloques;
    Cliente buscarCliente;//= Inicio.tablita.getAux();
    int mierdaC;
    Vehiculo buscarCarro;//= Inicio.arbolito.getCarros();
    Conductores conductor;//= Inicio.lcd.Buscar(Long.parseLong(TxtConductor.getText()));
    ListaEnlazada<MejorRuta> ruta;//= Inicio.graph.generarRuta(origen.getText(), destino.getText()); 
    //aca se va a generar el md5

    public Blockchain() {

        this.listabloques = new ListaEnlazada<>();
        this.mierdaC = 0;
        this.buscarCarro = null;
        this.buscarCliente = null;
        this.conductor = null;
        this.ruta = new ListaEnlazada<>();

        //
    }

    public void generarViaje(String origen, String destino, String cliente, String carro, String conductor) throws Exception {
        Inicio.arbolito.buscarCarro(carro);
        Inicio.tablita.buscar(BigInteger.valueOf(Long.parseLong(cliente)));

        Inicio.graph.generarRuta(origen, destino);
        ruta = Inicio.graph.getLista();

        this.conductor = Inicio.lcd.Buscar(Long.parseLong(conductor));
        buscarCarro = Inicio.arbolito.getCarros();
        buscarCliente = Inicio.tablita.getAux();
        mierdaC=Inicio.arbolito.getObtenerHash();

        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm"));
        String ll = generaLlaves(carro);
        String llaveEncriptada = generarHash(ll);
        //System.out.println(llaveEncriptada);
        //System.out.println(ll);
        listabloques.insertarFinal(new Bloque(origen, destino, FechaHora, buscarCliente, this.conductor, buscarCarro, llaveEncriptada, ruta));

    }

    public void imprimir(String llave) throws Exception {
        String nuevo = generarHash(llave);
        System.out.println(llave + "ESTA ES LA LLAVE");
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (listabloques.obtenerElemento(i).getLlave().equals(nuevo)) {
                //graficar el nodo

                System.out.println(listabloques.obtenerElemento(i).getLugarDestino() + " " + listabloques.obtenerElemento(i).getCliente().getFechaNac());
            }
        }
    }

    public void imprimirMejorRuta(String llave) throws Exception {
        String nuevo = generarHash(llave);
        System.out.println(llave + "ESTA ES LA LLAVE");

        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (listabloques.obtenerElemento(i).getLlave().equals(nuevo)) {
                int tam = listabloques.obtenerElemento(i).getRuta().getTamanio();
                for (int j = 0; j < tam; j++) {
                    System.out.println("Origen :" + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarOrigen() + " Destino: " + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarDestino() + " Tiempo: " + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getTiemp());
                }

                //graficar el nodo
                // System.out.println(Inicio.graph.lista.obtenerElemento(i).getLugarDestino() + " " + Inicio.graph.lista.obtenerElemento(i).getLugarOrigen() + " " + Inicio.graph.lista.obtenerElemento(i).getTiempoRuta());
            }
        }
    }

    public void ReporteBC() {
        // ordena_lista(primero);
        try {
            FileWriter archivo = new FileWriter("ReporteBC.dot");
            archivo.write("digraph G {\n\n");

            //CONTENIDO
            archivo.write(graficar());

            archivo.write("\n}");
            archivo.close();
            // archivo.write(contadorUsuarios + ";\n}");

            String abrir = "dot -Tpng " + "ReporteBC" + ".dot -o " + "ReporteBC" + ".png";
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec(abrir);
            archivo.close();
            System.out.println("REPORTE DE CONDUCTORES CREADO");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String graficar2() {
        String text = "";
        text += " rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n";
        text += "labelloc = \"t;\"label = \"REPORTE BLOCKCHAIN\";\n";
        //CONTENIDO
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            //if(listabloques.obtenerElemento(i).getLlave().equals(nuevo)){
            //graficar el nodo
            text += "x" + listabloques.obtenerElemento(i).getLlave() + "[dir=both label = \"Llave = " + listabloques.obtenerElemento(i).getLlave() + "\\nLugar Origen = " + listabloques.obtenerElemento(i).getLugarOrigen() + "\\n Lugar Destino = " + listabloques.obtenerElemento(i).getLugarDestino() + "\\n Cliente = " + listabloques.obtenerElemento(i).getCliente().getNombre() + "\\n Conductor = " + listabloques.obtenerElemento(i).getConductor().getNombre() + "\\n Vehiculo = " + listabloques.obtenerElemento(i).getVehiculo().getPlaca() + "\"]";
            if ((i + 1) < listabloques.getTamanio()) {
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> x" + listabloques.obtenerElemento(i + 1).getLlave() + "\n";

                //text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> x" + listabloques.obtenerElemento(i).;
            }
            if (i + 1 == listabloques.getTamanio()) {
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> x" + listabloques.obtenerElemento(i).getConductor().getDPI() + "\n";
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> Nodo" +  Inicio.arbolito.getObtenerHash() + "\n";
                 text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> Nodo" +  Inicio.tablita.getObtenerHash() + "\n";
            }

            //System.out.println(listabloques.obtenerElemento(i).getLugarDestino() + " " + listabloques.obtenerElemento(i).getCliente().getFechaNac());
            //}
        }
        return text;
    }

    public String graficar() {
        String text = "";
        text += " rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n";
        text += "labelloc = \"t;\"label = \"REPORTE BLOCKCHAIN\";\n";
        //CONTENIDO
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            //if(listabloques.obtenerElemento(i).getLlave().equals(nuevo)){
            //graficar el nodo
            text += "x" + listabloques.obtenerElemento(i).getLlave() + "[dir=both label = \"Llave = " + listabloques.obtenerElemento(i).getLlave() + "\\nLugar Origen = " + listabloques.obtenerElemento(i).getLugarOrigen() + "\\n Lugar Destino = " + listabloques.obtenerElemento(i).getLugarDestino() + "\\n Cliente = " + listabloques.obtenerElemento(i).getCliente().getNombre() + "\\n Conductor = " + listabloques.obtenerElemento(i).getConductor().getNombre() + "\\n Vehiculo = " + listabloques.obtenerElemento(i).getVehiculo().getPlaca() + "\"]";
            if ((i + 1) < listabloques.getTamanio()) {
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> x" + listabloques.obtenerElemento(i + 1).getLlave() + "\n";

            }

            //System.out.println(listabloques.obtenerElemento(i).getLugarDestino() + " " + listabloques.obtenerElemento(i).getCliente().getFechaNac());
            //}
        }
        return text;
    }

    public String generaLlaves(String placa) {
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm")).trim().replace(" ", "").toUpperCase();
        String fec = placa + FechaHora;//quita espacio y transforma a mayuscula
        System.out.println("Fecha hora: " + placa + FechaHora);
        return fec;

    }

    private String generarHash(String text) throws Exception {
        byte[] mensajeEncriptado = text.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] elMensaje = md.digest(mensajeEncriptado);
        String elHash = DatatypeConverter.printHexBinary(elMensaje).toUpperCase();
        System.out.println(elHash);
        return elHash;
    }

    public String Grafito() {
        String text = "";
        text += "subgraph cluster_Map{";
        text += Inicio.graph.report();
        text += "}\n\n";
        return text;
    }

    public String Driversitos() {
        String text1 = "";
        text1 += "subgraph cluster_Drivers{";
        text1 += Inicio.lcd.report();
        text1 += "}\n\n";
        return text1;
    }

    public String Arbolito() throws Exception {
        String text = "";
        text += "subgraph cluster_Tree{";
        text += "node[shape=record, style=filled,fillcolor=khaki, color =sienna , fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n labelloc = \"t;\"label = \"REPORTE CONDUCTORES\";";

        text += Inicio.arbolito.imprimirRaiz(Inicio.arbolito.raiz);
        text += "}\n\n";
        return text;
    }

    public String Hashito() throws Exception {
        String text2 = "";
        text2 += "subgraph cluster_Clientes{";
        text2 += "rankdir=LR\nnode[shape=record,style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n labelloc = \"t;\"label = \"REPORTE CLIENTES\";  ";
        text2 += Inicio.tablita.graficar();
        text2 += "}\n\n";
        return text2;
    }

    public String Blockchain() {
        String text = "";
        text += "subgraph cluster_Blockchain{";
        text += graficar2();
        text += "}\n\n";
        return text;
    }

    public void GraficarRG() throws Exception {
        try {
            FileWriter archivo = new FileWriter("ReporteGeneral.dot");
            archivo.write("digraph{\n\n");
            archivo.write("labelloc = \"t;\"label = \"REPORTE GENERAL\";\n\n");
            //CONTENIDO
            archivo.write(Grafito());
            archivo.write(Driversitos());
            archivo.write(Hashito());
            archivo.write(Arbolito());
            archivo.write(Blockchain());
            archivo.write("\n}\n\n");
            archivo.close();
            // archivo.write(contadorUsuarios + ";\n}");

            String abrir = "dot -Tpng " + "ReporteGeneral" + ".dot -o " + "ReporteGeneral" + ".jpg";
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec(abrir);
            archivo.close();

            System.out.println("REPORTE GENERAL");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
