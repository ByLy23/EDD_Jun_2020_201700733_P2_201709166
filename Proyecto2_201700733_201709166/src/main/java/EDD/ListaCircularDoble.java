/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import EDD.NodoLCD;
import Interfaz.ConductoresInterfaz;
import Principal.Conductores;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ListaCircularDoble {

    NodoLCD primero;
    NodoLCD ultimo;
    int tam;
    String nametemp;

    public ListaCircularDoble() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void Insertar(Conductores dato) {
        NodoLCD nuevo = new NodoLCD();
        nuevo.dato = dato;
        if (primero == null) {
            primero = nuevo;
            primero.next = primero;
            nuevo.before = ultimo;
            ultimo = nuevo;
        } else {
            ultimo.next = nuevo;
            nuevo.next = primero;
            nuevo.before = ultimo;
            ultimo = nuevo;
            primero.before = ultimo;
        }
        tam++;
    }

    public void Buscar(long dato) {
        NodoLCD actual = new NodoLCD();
        actual = ultimo;
        boolean found = false;
        do {
            if (actual.dato.getDPI() == dato) {
                found = true;
            }
            actual = actual.before;
        } while (actual != ultimo && found != true);
        if (found == true) {
            JOptionPane.showMessageDialog(null, "Conductor encontrado");

        } else {
            JOptionPane.showMessageDialog(null, "Conductor no encontrado");
        }
    }

    public void Eliminar(long dato) {
        NodoLCD actual = new NodoLCD();
        NodoLCD antes = new NodoLCD();
        actual = primero;
        antes = ultimo;
        do {
            if (actual.dato.getDPI() == dato) {
                if (actual == primero) {
                    primero = primero.next;
                    ultimo.next = primero;
                    primero.before = ultimo;
                } else if (actual == ultimo) {
                    ultimo = antes;
                    primero.before = ultimo;
                    ultimo.next = primero;
                } else {
                    antes.next = actual.next;
                    actual.next.before = antes;
                }
            }
            antes = actual;
            actual = actual.next;
        } while (actual != primero);
        JOptionPane.showMessageDialog(null, "Conductor eliminado");
    }

    public void Desplegar() {//Muestra todos los valores que la lista poseé
        NodoLCD actual = new NodoLCD();
        actual = primero;//Posicion incial de la lista
        do {
            System.out.println("" + actual.dato.getNombre());//Imprime los datos
            actual = actual.next;//Recorre la lista del principio al final
        } while (actual != primero);//Realiza el metodo mientras que la posicion actual sea distinta al inicio. 
    }

    public void Modificar(long DPI, String Nombre, String Apellido,String Licencia, String Genero, String Telefono, String Direccion) {
        NodoLCD actual = new NodoLCD();
        actual = primero;
        do {
            if (actual.dato.getDPI() == DPI) {
                actual.dato.setNombre(Nombre);
                actual.dato.setApellido(Apellido);
                actual.dato.setLicencia(Licencia);
                actual.dato.setGenero(Genero);
                actual.dato.setTelefono(Telefono);
                actual.dato.setDireccion(Direccion);

            }
        } while (actual != primero);

    }

    public String report() {
        NodoLCD aux = this.primero;
        String text = "";
        do {
            text+="x"+aux.dato.getDPI()+ "[dir=both label = \"DPI = "+ aux.dato.getDPI()+ "\\nNombre = "+aux.dato.getNombre()+" "+aux.dato.getApellido()+"\\n Licencia = "+aux.dato.getLicencia()+"\\n Direccion = "+aux.dato.getDireccion()+ "\"]";
            text+="x"+aux.dato.getDPI()+"-> x"+aux.next.dato.getDPI()+"\n";
            aux = aux.next;
        } while (aux != primero);
        return text;

    }

    public void ReporteLCD() {
        try {
            FileWriter archivo = new FileWriter("ReporteConductores.dot");
            archivo.write("digraph G {" + "\n rankdir=LR; \n node[shape = egg, color = purple];\n");
            archivo.write("labelloc = \"t;\"label = \"REPORTE CONDUCTORES\";\n");
            //CONTENIDO
            archivo.write(report());

            archivo.write("\n}");
            archivo.close();
            // archivo.write(contadorUsuarios + ";\n}");

            String abrir = "dot -Tpng " + "ReporteConductores" + ".dot -o " + "ReporteConductores" + ".png";
            Runtime tiempoEjecucion = Runtime.getRuntime();
            Process proceso = tiempoEjecucion.exec(abrir);
            archivo.close();
            System.out.println("REPORTE DE CONDUCTORES CREADO");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
