/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Principal.Cliente;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    Cliente aux;
    private float porcentajeUtilizacion;

    public Cliente getAux() {
        return aux;
    }

    public void setAux(Cliente aux) {
        this.aux = aux;
    }

    int obtenerHash;

    public int getObtenerHash() {
        return obtenerHash;
    }

    public void setObtenerHash(int obtenerHash) {
        this.obtenerHash = obtenerHash;
    }

    public TablaHash() {
        posicion = 0;
        espacioOcupado = 0;
        arregloDeTamanios = new int[]{37, 74, 111, 148, 185, 222, 259, 296, 333, 370, 407};
        size = arregloDeTamanios[posicion];
        listaClientes = new ListaEnlazada[size];
        porcentajeUtilizacion = obtenerUtilizacion();
        inicializarListas(size);

    }

    private void inicializarListas(int ma) {
        for (int i = 0; i < ma; i++) {
            listaClientes[i] = new ListaEnlazada();
        }

    }

    public void insertarClientes(BigInteger dpi, String nombre, String apellido, String genero, int telefono, String direccion, String fechaNac) {
        Cliente cliente = new Cliente(dpi, nombre, apellido, genero, telefono, direccion, fechaNac);
        if (porcentajeUtilizacion <= 75.00f) {
            int deposito = dispersion(dpi);
            if (deposito < size) {
                boolean repetido = buscar(dpi);
                if (!repetido) {
                    if (listaClientes[deposito] == null) {
                        listaClientes[deposito].insertarInicio(cliente);
                    } else {
                        listaClientes[deposito].insertarInicio(cliente);
                    }
                    espacioOcupado++;
                    porcentajeUtilizacion = obtenerUtilizacion();
                } else {
                    JOptionPane.showMessageDialog(null, "Persona Repetida");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se hara reinsercion: " + porcentajeUtilizacion + "% de espacio utilizado");
            reinsertar();
            insertarClientes(dpi, nombre, apellido, genero, telefono, direccion, fechaNac);
        }
    }

    private void reinsertar() {
        ListaEnlazada<Cliente>[] clientes = listaClientes;
        int tamanio = size;
        if (posicion < arregloDeTamanios.length) {
            posicion++;
            if (posicion == arregloDeTamanios.length - 1) {
                JOptionPane.showMessageDialog(null, "Se alcanzo el maximo we xD");
            }
        }
        size = arregloDeTamanios[posicion];
        listaClientes = new ListaEnlazada[size];
        espacioOcupado = 0;
        porcentajeUtilizacion = obtenerUtilizacion();
        inicializarListas(size);
        for (int i = 0; i < tamanio; i++) {
            if (clientes[i] != null) {
                for (int j = 0; j < clientes[i].getTamanio(); j++) {
                    insertarClientes(clientes[i].obtenerElemento(j).getDPI(), clientes[i].obtenerElemento(j).getNombre(), clientes[i].obtenerElemento(j).getApellido(), clientes[i].obtenerElemento(j).getGenero(), clientes[i].obtenerElemento(j).getTelefono(), clientes[i].obtenerElemento(j).getDireccion(), clientes[i].obtenerElemento(j).getFechaNac());
                }
            }
        }
    }


    public boolean buscar(BigInteger dpi) {

        for (int i = 0; i < size; i++) {
            if (listaClientes[i] != null) {
                /*if(listaClientes[i].getTamanio()==0){
                    if(listaClientes[i])
                }*/
                for (int j = 0; j < listaClientes[i].getTamanio(); j++) {
                    if (listaClientes[i].obtenerElemento(j).getDPI().equals(dpi)) {
                        pos = i;
                        elemento = j;
                        setAux(listaClientes[i].obtenerElemento(j));
                        setObtenerHash(listaClientes[i].obtenerElemento(j).hashCode());

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void modificarDatos(BigInteger dpi, String nombre, String apellido, String genero, int telefono, String direccion, String fechaNac) {
        boolean bandera = buscar(dpi);
        if (bandera) {
            for (int i = 0; i < size; i++) {
                if (listaClientes[i] != null) {
                    for (int j = 0; j < listaClientes[i].getTamanio(); j++) {
                        if (listaClientes[i].obtenerElemento(j).getDPI().equals(dpi)) {
                            listaClientes[i].obtenerElemento(j).setDPI(dpi);
                            listaClientes[i].obtenerElemento(j).setNombre(nombre);
                            listaClientes[i].obtenerElemento(j).setApellido(apellido);
                            listaClientes[i].obtenerElemento(j).setGenero(genero);
                            listaClientes[i].obtenerElemento(j).setTelefono(telefono);
                            listaClientes[i].obtenerElemento(j).setDireccion(direccion);
                            listaClientes[i].obtenerElemento(j).setFechaNac(fechaNac);
                        }
                    }
                }
            }
        }
    }

    public void eliminarDatos(BigInteger dpi) {
        boolean bandera = buscar(dpi);
        if (bandera) {
            listaClientes[pos].eliminar(elemento);
            JOptionPane.showMessageDialog(null, "Dato Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el usuario");
        }
    }

    private int obtenerUtilizacion() {
        return (espacioOcupado * 100) / size;
    }

    private int dispersion(BigInteger dpi) {
        BigInteger numero = dpi.mod(BigInteger.valueOf(size));
        int num = numero.intValue();
        return num;
    }

    public String graficar() throws Exception {
        String b = "";
        b = "Nodo" + listaClientes.hashCode();
        b += "[label= \n\"<P0>\\n\\n";
        for (int i = 0; i < size; i++) {
            b += i + "\\n\\n----------\\n\\n";
            b += "|<P" + (i + 1) + ">";
        }
        b += "\"];\n";
        for (int i = 0; i < size; i++) {
            if (listaClientes[i].getTamanio() != 0) {
                for (int j = 0; j < listaClientes[i].getTamanio(); j++) {
                    b += "Nodo" + listaClientes[i].obtenerElemento(j).hashCode();
                    b += "[label=\" DPI: " + listaClientes[i].obtenerElemento(j).getDPI();
                    b += "\\nNombre: " + listaClientes[i].obtenerElemento(j).getNombre() + " " + listaClientes[i].obtenerElemento(j).getApellido();
                    b += "\\nGenero: " + listaClientes[i].obtenerElemento(j).getGenero();
                    b += "\\nTelefono: " + listaClientes[i].obtenerElemento(j).getTelefono();
                    b += "\\nFecha Nacimiento: " + listaClientes[i].obtenerElemento(j).getFechaNac();
                    b += "\\nDireccion: " + listaClientes[i].obtenerElemento(j).getDireccion();
                    b += "\"];\n";
                    if ((j + 1) < listaClientes[i].getTamanio()) {
                        b += "Nodo" + listaClientes[i].obtenerElemento(j).hashCode() + " -> Nodo" + listaClientes[i].obtenerElemento(j + 1).hashCode() + "\n";
                    }
                }
                b += "Nodo" + listaClientes.hashCode() + ":P" + i + " -> Nodo" + listaClientes[i].obtenerElemento(0).hashCode() + "\n";
            }
        }
        generarImagen(b);
        return b;
    }

    private void generarImagen(String b) throws Exception {
        String datos = "digraph G{\n rankdir=LR\nnode[shape=record,style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n labelloc = \"t;\"label = \"REPORTE CLIENTES\";  " + b + "\n}";
        FileWriter file = new FileWriter("Hash.dot");
        PrintWriter impresion = new PrintWriter(file);
        impresion.println(datos);
        file.close();
        String comando = "dot -Tpng Hash.dot -o Hash.jpg -Gcharset=latin1";
        Runtime rt = Runtime.getRuntime();
        rt.exec(comando);
        Thread.sleep(500);
    }

    public void cargaMasiva(String carga) {
        String[] saltoLinea = carga.split(";");
        for (String saltoLinea1 : saltoLinea) {
            String[] lectura = saltoLinea1.split(",");
            insertarClientes(BigInteger.valueOf(Long.valueOf(lectura[0])), lectura[1], lectura[2], lectura[3], Integer.parseInt(lectura[5]), lectura[6], lectura[4]);
        }
    }
}
