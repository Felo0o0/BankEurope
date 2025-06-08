/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * @author felix
 */

package com.bankeurope.modelo.cliente;

import com.bankeurope.modelo.InfoCliente;

/**
 * Clase que representa un cliente del banco
 */
public class Cliente implements InfoCliente {
    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;
    
    // Constructor
    public Cliente(String nombre, String apellido, String rut, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getRut() {
        return rut;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    // Metodo para mostrar informacion basica del cliente
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("RUT: " + rut);
        System.out.println("Telefono: " + telefono);
    }
    
    // Implementacion del metodo de la interfaz
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("=== DATOS PERSONALES ===");
        System.out.println("Nombre completo: " + nombre + " " + apellido);
        System.out.println("RUT: " + rut);
        System.out.println("Telefono de contacto: " + telefono);
    }
}
