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

import Principal.ViajeCliente;
import Principal.ViajeConductor;
import Principal.ViajeVehiculo;


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

        mierdaC = Inicio.arbolito.getObtenerHash();


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
    public String nuevo;

    public void imprimirMejorRuta(String llave) throws Exception {
        nuevo = generarHash(llave);
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

    public void MejorRuta(String ruta) throws Exception {
        // ordena_lista(primero);
        try {
            FileWriter archivo = new FileWriter("ReporteMejorRuta.dot");
            archivo.write("digraph G {\n\n");

            //CONTENIDO
            archivo.write(imprimirMejorRutaG(ruta));

            archivo.write("\n}");
            archivo.close();
            // archivo.write(contadorUsuarios + ";\n}");

            String abrir = "dot -Tpng " + "ReporteMejorRuta" + ".dot -o " + "ReporteMejorRuta" + ".png";
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec(abrir);
            archivo.close();
            System.out.println("REPORTE DE MEJOR RUTA CREADO");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> Nodo" + Inicio.arbolito.getObtenerHash() + "\n";
                text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> Nodo" + Inicio.tablita.getObtenerHash() + "\n";

                int tam = listabloques.obtenerElemento(i).getRuta().getTamanio();
                for (int j = 0; j < tam; j++) {
                    if (j == 0) {
                        text += "x" + listabloques.obtenerElemento(i).getLlave() + "-> br" + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarOrigen() + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarDestino() + "\n";

                    }
                }

            }

            //System.out.println(listabloques.obtenerElemento(i).getLugarDestino() + " " + listabloques.obtenerElemento(i).getCliente().getFechaNac());
            //}
        }
        return text;

        
    }
    ViajeCliente[] topClientes;
    public String top10Clientes(){
        String top10C="";
        topClientes= new ViajeCliente[listabloques.getTamanio()];
        /*   for (int i = 0; i < listabloques.getTamanio(); i++) {
        topClientes[i]= new ViajeCliente();
        }*/
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (verificarCliente(String.valueOf(listabloques.obtenerElemento(i).getCliente().getDPI()))) {
            } 
        }
        ordenarCliente(topClientes);
        for (int i = 0; i < 10; i++) {
            if(topClientes[i]!=null)
                top10C+="Nombre Cliente: "+topClientes[i].getNombre()+" Con :"+topClientes[i].getTiempo()+" Viajes\n";
        }
        return top10C;
    }
    private boolean verificarCliente(String cliente){
        boolean bandera=false;
        for (ViajeCliente topClientess : topClientes) {
            if (topClientess != null) {
                if (topClientess.getNombre().equals(cliente)) {
                    topClientess.sumar();
                    bandera=true;
                    break;
                }
            }
        }
        if(!bandera){
            for (int i = 0; i < topClientes.length; i++) {
                if(topClientes[i]==null){
                    topClientes[i]= new ViajeCliente(cliente);
                    break;
                }
            }
        }
        return bandera;
    }
    
       ViajeVehiculo[] topVehiculo;
    public String top10Vehiculo(){
        String top10V="";
        topVehiculo= new ViajeVehiculo[listabloques.getTamanio()];
        /*   for (int i = 0; i < listabloques.getTamanio(); i++) {
        topVehiculos[i]= new ViajeVehiculo();
        }*/
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (verificarVehiculo(listabloques.obtenerElemento(i).getVehiculo().getPlaca())) {
            } 
        }
        ordenarVehiculo(topVehiculo);
        for (int i = 0; i < 10; i++) {
            if(topVehiculo[i]!=null)
                  top10V+="Placa vehiculo: "+topVehiculo[i].getNombre()+" Con :"+topVehiculo[i].getCantidad()+" Viajes\n";
        }
        return top10V;
    }
    private boolean verificarVehiculo(String Vehiculo){
        boolean bandera=false;
        for (ViajeVehiculo topVehiculos : topVehiculo) {
            if (topVehiculos != null) {
                if (topVehiculos.getNombre().equals(Vehiculo)) {
                    topVehiculos.sumar();
                    bandera=true;
                    break;
                }
            }
        }
        if(!bandera){
            for (int i = 0; i < topVehiculo.length; i++) {
                if(topVehiculo[i]==null){
                    topVehiculo[i]= new ViajeVehiculo(Vehiculo);
                }
            }
        }
        return bandera;
    }
    
    private void ordenarConductor(ViajeConductor[] cadena){
        for (int i = 0; i < cadena.length; i++) {
            for (int j = 0; j < cadena.length-i-1; j++) {
                if(cadena[i]!=null || cadena[i+1]!=null){
                if(cadena[i].getCantidad()<cadena[i+1].getCantidad())
                {
                    ViajeConductor temp= cadena[i+1];
                    cadena[i+1]=cadena[i];
                    cadena[i]=temp;
                    
                }
                }
            }
        }
    }
    private void ordenarVehiculo(ViajeVehiculo[] cadena){
        for (int i = 0; i < cadena.length; i++) {
            for (int j = 0; j < cadena.length-i-1; j++) {
                if(cadena[i]!=null || cadena[i+1]!=null){
                if(cadena[i].getCantidad()<cadena[i+1].getCantidad())
                {
                    ViajeVehiculo temp= cadena[i+1];
                    cadena[i+1]=cadena[i];
                    cadena[i]=temp;
                }
                }
            }
        }
    }
    private void ordenarCliente(ViajeCliente[] cadena){
        for (int i = 0; i < cadena.length; i++) {
            for (int j = 0; j < cadena.length-i-1; j++) {
              if(!(cadena[i+1]==null)||!(cadena[i]==null) ){
                if(cadena[i].getTiempo()<cadena[i+1].getTiempo())
                {
                    ViajeCliente temp= cadena[i+1];
                    cadena[i+1]=cadena[i];
                    cadena[i]=temp;
                    
                }
            }
            }
        }
    }
    
    
    ViajeConductor[] topConductor;
    public String top10Conductor(){
        String top10Co="";
        topConductor= new ViajeConductor[listabloques.getTamanio()];
        /*   for (int i = 0; i < listabloques.getTamanio(); i++) {
        topConductors[i]= new ViajeConductor();
        }*/
         for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (verificarConductor(Long.toString(listabloques.obtenerElemento(i).getConductor().getDPI()))) {
            } 
        }
        ordenarConductor(topConductor);
        for (int i = 0; i < 10; i++) {
            if(topConductor[i]!=null)
                top10Co+="Nombre Conductor: "+topConductor[i].getNombre()+" Con :"+topVehiculo[i].getCantidad()+" Viajes\n";
        }
        return top10Co;
    }
    private boolean verificarConductor(String Conductor){
        boolean bandera=false;
        for (ViajeConductor topConductores : topConductor) {
            if (topConductores != null) {
                if (topConductores.getNombre().equals(Conductor)) {
                    topConductores.sumar();
                    bandera=true;
                    break;
                }
            }
        }
        if(!bandera){
            for (int i = 0; i < topConductor.length; i++) {
                if(topConductor[i]==null){
                    topConductor[i]= new ViajeConductor(Conductor);
                }
            }
        }
        return bandera;
    }
    
    
    

    public String imprimirMejorRutaG(String llave) throws Exception {
        String mejor = "";
        mejor += " rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n";
        mejor += "labelloc = \"t;\"label = \"REPORTE MEJOR RUTA\";\n";

        nuevo = generarHash(llave);
        System.out.println(llave + "ESTA ES LA LLAVE");

        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if (listabloques.obtenerElemento(i).getLlave().equals(nuevo)) {
                int tam = listabloques.obtenerElemento(i).getRuta().getTamanio();
                for (int j = 0; j < tam; j++) {
                    mejor += "br" + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarOrigen() + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarDestino() + "[dir=both label = \"Lugar = " + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarDestino() + " Tiempo: " + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getTiemp() + "\"]";
                    if ((j + 1) < tam) {
                        mejor += "br" + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarOrigen() + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j).getLugarDestino() + "-> br" + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j + 1).getLugarOrigen() + listabloques.obtenerElemento(i).getRuta().obtenerElemento(j + 1).getLugarDestino() + "\n";
                    }
                }
            }
            //graficar el nodo
            // System.out.println(Inicio.graph.lista.obtenerElemento(i).getLugarDestino() + " " + Inicio.graph.lista.obtenerElemento(i).getLugarOrigen() + " " + Inicio.graph.lista.obtenerElemento(i).getTiempoRuta());
        }

        return mejor;
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
    String llaveHDP;

    public String getLlaveHDP() {
        return llaveHDP;
    }

    public void setLlaveHDP(String llaveHDP) {
        this.llaveHDP = llaveHDP;
    }

    public String generaLlaves(String placa) {
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm")).trim().replace(" ", "").toUpperCase();
        String fec = placa + FechaHora;//quita espacio y transforma a mayuscula
        setLlaveHDP(fec);
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
        text2 += "subgraph getLlaveHDPcluster_Clientes{";
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

    public String MejorRuta() throws Exception {
        String text = "";
        text += "subgraph cluster_MejorRuta{";
        text += imprimirMejorRutaG(getLlaveHDP());
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
            archivo.write(MejorRuta());
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
