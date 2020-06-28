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
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
          this.listabloques=null;
          this.buscarCarro=null;
          this.buscarCliente=null;
          this.conductor=null;
          this.ruta=null;
        //
    }
    public void generarViaje(String origen, String destino, String cliente, String carro, String conductor){
        Inicio.arbolito.buscarCarro(carro);
        Inicio.tablita.buscar(BigInteger.valueOf(Long.parseLong(cliente)));
        ruta= Inicio.graph.generarRuta(origen, destino);
        this.conductor= Inicio.lcd.Buscar(Long.parseLong(conductor));
        buscarCarro=Inicio.arbolito.getCarros();
        buscarCliente= Inicio.tablita.getAux();
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm"));
        listabloques.insertarFinal(new Bloque(origen,destino,FechaHora,buscarCliente,this.conductor,buscarCarro,generaLlaves(carro)));
    }
    public String generaLlaves(String placa)
    {
        LocalDateTime actualTiempo = LocalDateTime.now();
        String FechaHora = actualTiempo.format(DateTimeFormatter.ofPattern("ddMMyy HH:mm")).trim().replace(" ", "").toUpperCase(); //quita espacio y transforma a mayuscula
    
        System.out.println("Fecha hora: " + placa + FechaHora);
        return placa + FechaHora;
    }
    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
		e.printStackTrace();
		return null;
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
	    
	return sb.toString();
}
}
