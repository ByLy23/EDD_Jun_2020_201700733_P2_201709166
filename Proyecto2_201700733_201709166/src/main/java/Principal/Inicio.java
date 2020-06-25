/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EDD.ArbolB;
import EDD.TablaHash;
import java.math.BigInteger;

/**
 *
 * @author byron
 */
public class Inicio {
    public static void main(String[] args) throws Exception
    {
       /* System.out.println("Pruebas");
        TablaHash tab= new TablaHash();
        tab.insertarClientes(new BigInteger("3045646514571"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3049646514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3042646514508"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045676514509"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3075646514507"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3456486514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("9045646514506"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646514561"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646214501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.insertarClientes(new BigInteger("3045646514501"), "Byron", "Orellana", "Masculino", 51313792, "Mi casa", "19/19/19");
        tab.graficar();*/
        ArbolB arb= new ArbolB();
        //Vehiculo car=new Vehiculo("113BPB", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica");
        arb.Insertar(new Vehiculo("A", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("B", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("C", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("D", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("E", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("F", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("G", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("H", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("I", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.Insertar(new Vehiculo("J", "Mitsubishi", "Modelo", 2006, "Rojo", 2500, "Mecanica"));
        arb.imprimirNodo();
    }
}
