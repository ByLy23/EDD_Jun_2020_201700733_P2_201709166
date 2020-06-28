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
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

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
            primero=ultimo=nuevo;
            nuevo.before=nuevo;
            nuevo.next=nuevo;
        } else {
            nuevo.before=ultimo;
            ultimo.next=nuevo;
            nuevo.next=primero;
            primero.before=nuevo;
            ultimo=nuevo;
            
        }
        tam++;
       // ordena_lista(nuevo);
    }

    public Conductores Buscar(long dato) {
        Conductores conductor= null;
        NodoLCD actual;
        actual = primero;
        boolean found = false;
        do {
            if (actual.dato.getDPI() == dato) {
                found = true;
                break;
            }
            actual = actual.next;
        } while (actual != ultimo.next);
        if (found) {
            JOptionPane.showMessageDialog(null, "Conductor encontrado");
            conductor=actual.dato;
            
        } else {
            JOptionPane.showMessageDialog(null, "Conductor no encontrado");
        }
        return conductor;
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

    public void Modificar(long DPI, String Nombre, String Apellido, String Licencia, String Genero, String Telefono, String Direccion) {
        NodoLCD actual;
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
            actual= actual.next;
        } while (actual == ultimo);

    }

    public String report() {
        NodoLCD aux = this.primero;
        String text = "";
        do {
            text += "x" + aux.dato.getDPI() + "[dir=both label = \"DPI = " + aux.dato.getDPI() + "\\nNombre = " + aux.dato.getNombre() + " " + aux.dato.getApellido() + "\\n Licencia = " + aux.dato.getLicencia() + "\\n Direccion = " + aux.dato.getDireccion() + "\"]";
            text += "x" + aux.dato.getDPI() + "-> x" + aux.next.dato.getDPI() + "\n";
            text += "x" + aux.dato.getDPI() + "-> x" + aux.before.dato.getDPI() + "\n";

            aux = aux.next;
        } while (aux != primero);
        return text;

    }
     NodoLCD actual;
                NodoLCD anterior;
                NodoLCD siguiente;

    public void ordena_lista(ListaCircularDoble nodo) {
        if(nodo!=null){
            NodoLCD aux=null;
            NodoLCD actual=null;
            long cant=0;
            aux=nodo.primero;
            while(aux!=nodo.ultimo){
            actual=aux.next;
                while(actual!=null){
                    if(aux.dato.getDPI()>actual.dato.getDPI()){
                        cant=aux.dato.getDPI();
                    //    aux.dato.getDPI()=actual.dato.getDPI();
                       cant=actual.dato.getDPI();
                    }
                    actual=actual.next;
                }
                aux=aux.next;
            }
        }else{
                System.out.println("Lista no iniciliazada");
        }
        
       /* if (tam>1) {
            boolean changes;
            do{
                 NodoLCD actual=primero;
                NodoLCD anterior=null;
                NodoLCD siguiente=primero.next;
                changes=false;
                
                while(siguiente!=null){
                    if(actual.dato.getDPI()>siguiente.dato.getDPI()){
                    changes=true;
                        if(anterior!=null)
                        {
                            NodoLCD sig=siguiente.next;
                            anterior.next=siguiente;
                            siguiente.next=actual;
                            actual.next=sig;
                                   
                        }else{
                             NodoLCD sig=siguiente.next;
                             primero=siguiente;
                             siguiente.next=actual;
                             actual.next=sig;
                                    
                        }
                        anterior=siguiente;
                        siguiente = actual.next;
                                
                        
                    }else{
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.next;
                    }
                    
                }
            }while(changes);
        }*/
       
       
    }

    public void ReporteLCD() {
       // ordena_lista(primero);
        try {
            FileWriter archivo = new FileWriter("ReporteConductores.dot");
            archivo.write("digraph G {" + "\n rankdir=LR; \n node[shape = egg, style=filled, color = khaki, fontname = \"Century Gothic\"]; graph [fontname = \"Century Gothic\"];\n" );
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
