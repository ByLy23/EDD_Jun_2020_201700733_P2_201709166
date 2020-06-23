/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Cliente;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author byron
 */
public class TablaHash {
    ListaEnlazada<Cliente>[] listaClientes;
    private int posicion;
    private static int[] arregloDeTamanios;
    private int size;
    private int pos;
    private int elemento;
    private int espacioOcupado;
    private float porcentajeUtilizacion;
    public TablaHash()
    {
        posicion=0;
        espacioOcupado=0;
       arregloDeTamanios =new int[]{37,74,111,148,185,222,259,296,333,370,407};
       size= arregloDeTamanios[posicion];
       listaClientes= new ListaEnlazada[size];
       porcentajeUtilizacion= obtenerUtilizacion();
       
    }
    public void insertarClientes(BigInteger dpi,String nombre, String apellido, char genero, int telefono, String direccion)
    {
        Cliente cliente= new Cliente(dpi,nombre,apellido,genero,telefono,direccion);
        if(porcentajeUtilizacion<=75.00f)
        {
            int deposito= dispersion(dpi);
            if(deposito<size)
            {
                boolean repetido= buscar(dpi);
                if(!repetido){
                if(listaClientes[deposito]==null){
                   listaClientes[deposito].insertarInicio(cliente);
                }else{
                    listaClientes[deposito].insertarInicio(cliente);
                }
                espacioOcupado++;
                   porcentajeUtilizacion=obtenerUtilizacion();
                }else{
                    JOptionPane.showMessageDialog(null, "Persona Repetida");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se hara reinsercion: "+porcentajeUtilizacion+"% de espacio utilizado");
            reinsertar();
            insertarClientes(dpi, nombre, apellido, genero, telefono, direccion);
        }
    }
    private void reinsertar(){
        ListaEnlazada<Cliente>[] clientes;
        int tamanio= size;
        if(posicion<arregloDeTamanios.length){
            posicion++;
            if(posicion==arregloDeTamanios.length-1)JOptionPane.showMessageDialog(null, "Se alcanzo el maximo we xD");
        }
        size= arregloDeTamanios[posicion];
        clientes= new ListaEnlazada[size];
        espacioOcupado=0;
        porcentajeUtilizacion=obtenerUtilizacion();
        for (int i = 0; i < tamanio; i++) {
            if(clientes[i]!=null){
                for (int j = 0; j < clientes[i].getTamanio(); j++) {
                    insertarClientes(clientes[i].obtenerElemento(j).getDPI(), clientes[i].obtenerElemento(j).getNombre(), clientes[i].obtenerElemento(j).getApellido(),clientes[i].obtenerElemento(j).getGenero(),clientes[i].obtenerElemento(j).getTelefono(),clientes[i].obtenerElemento(j).getDireccion());
                }
            }
        }
    }
    private boolean buscar(BigInteger dpi){
        for (int i = 0; i < size; i++) {
            if(listaClientes[i]!=null){
                for (int j = 0; j < listaClientes[i].getTamanio(); j++) {
                    if(listaClientes[i].obtenerElemento(j).getDPI()==dpi){
                        pos=i;
                        elemento=j;
                        return true;
                    }
                    }
            }
        }
        return false;
    }
    public void modificarDatos(BigInteger dpi,String nombre, String apellido, char genero, int telefono, String direccion){
        boolean bandera= buscar(dpi);
        if(bandera){
            for (int i = 0; i < size; i++) {
            if(listaClientes[i]!=null){
                for (int j = 0; j < listaClientes[i].getTamanio(); j++) {
                    if(listaClientes[i].obtenerElemento(j).getDPI()==dpi){
                       listaClientes[i].obtenerElemento(j).setDPI(dpi);
                       listaClientes[i].obtenerElemento(j).setNombre(nombre);
                       listaClientes[i].obtenerElemento(j).setApellido(apellido);
                       listaClientes[i].obtenerElemento(j).setGenero(genero);
                       listaClientes[i].obtenerElemento(j).setTelefono(telefono);
                       listaClientes[i].obtenerElemento(j).setDireccion(direccion);
                    }
                    }
            }
        }
        }
    }
    public void eliminarDatos(BigInteger dpi)
    {
        boolean bandera= buscar(dpi);
        if(bandera){
            listaClientes[pos].eliminar(elemento);
            JOptionPane.showMessageDialog(null, "Dato Eliminado");
        }else
            JOptionPane.showMessageDialog(null, "No se encontro el usuario");
    }
    private int obtenerUtilizacion(){
        return (espacioOcupado*100)/size;
    }
    
    private int dispersion(BigInteger dpi){
        BigInteger numero= dpi.mod(BigInteger.valueOf(size));
        int num= numero.intValue();
        return num;
    }
}
