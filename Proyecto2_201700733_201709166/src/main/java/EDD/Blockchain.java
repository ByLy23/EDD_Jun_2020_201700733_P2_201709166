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
import Principal.Rutas;
import Principal.Vehiculo;
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
         Vehiculo buscarCarro;//= Inicio.arbolito.getCarros();
         Conductores conductor;//= Inicio.lcd.Buscar(Long.parseLong(TxtConductor.getText()));
         ListaEnlazada<Rutas> ruta;//= Inicio.graph.generarRuta(origen.getText(), destino.getText()); 
    //aca se va a generar el md5
    public Blockchain(){
          this.listabloques=new ListaEnlazada<>();
          this.buscarCarro=null;
          this.buscarCliente=null;
          this.conductor=null;
          this.ruta=new ListaEnlazada<>();
        //
    }
    public void generarViaje(String origen, String destino, String cliente, String carro, String conductor) throws Exception{
        Inicio.arbolito.buscarCarro(carro);
        Inicio.tablita.buscar(BigInteger.valueOf(Long.parseLong(cliente)));
        Inicio.graph.generarRuta(origen, destino);
        ruta=Inicio.graph.getLista();
        this.conductor= Inicio.lcd.Buscar(Long.parseLong(conductor));
        buscarCarro=Inicio.arbolito.getCarros();
        buscarCliente= Inicio.tablita.getAux();
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm"));
        String ll= generaLlaves(carro);
        String llaveEncriptada= generarHash(ll);
        System.out.println(llaveEncriptada);
        System.out.println(ll);
        listabloques.insertarFinal(new Bloque(origen,destino,FechaHora,buscarCliente,this.conductor,buscarCarro,llaveEncriptada));
    }
    public void imprimir(String llave) throws Exception{
        String nuevo= generarHash(llave);
        System.out.println(llave+"ESTA ES LA LLAVE");
        for (int i = 0; i < listabloques.getTamanio(); i++) {
            if(listabloques.obtenerElemento(i).getLlave().equals(nuevo)){
                //graficar el nodo
                System.out.println(listabloques.obtenerElemento(i).getLugarDestino()+" "+ listabloques.obtenerElemento(i).getCliente().getFechaNac());
            }
        }
    }
    public String generaLlaves(String placa)
    {
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm")).trim().replace(" ", "").toUpperCase();
        String fec=placa+FechaHora;//quita espacio y transforma a mayuscula
        System.out.println("Fecha hora: " + placa + FechaHora);
        return fec;
    }
    private String generarHash(String text) throws Exception{
        byte[] mensajeEncriptado= text.getBytes("UTF-8");
        MessageDigest md= MessageDigest.getInstance("MD5");
        byte[] elMensaje= md.digest(mensajeEncriptado);
        String elHash= DatatypeConverter.printHexBinary(elMensaje).toUpperCase();
        System.out.println(elHash);
        return elHash;        
    }
}
