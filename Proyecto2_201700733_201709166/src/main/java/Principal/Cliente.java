/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.math.BigInteger;

/**
 *
 * @author byron
 */
public class Cliente {


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getDPI() {
        return DPI;
    }

    public void setDPI(BigInteger DPI) {
        this.DPI = DPI;
    }

    public Cliente(BigInteger DPI, String nombre, String apellido, String genero, int telefono, String direccion, String fechaNac) {
        this.DPI = DPI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNac=fechaNac;
    }
    
    private BigInteger DPI;
    private String nombre;
    private String apellido;
    private String genero;
    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    private String fechaNac;
    private int telefono;
    private String direccion;
}
