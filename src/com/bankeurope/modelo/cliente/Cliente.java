/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.modelo.cliente;

import com.bankeurope.modelo.InfoCliente;

/**
 * Clase que representa un cliente del banco
 * Contiene la informacion personal del cliente y metodos para
 * gestionar y mostrar dicha informacion.
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class Cliente implements InfoCliente {
    // Atributos privados para mantener el encapsulamiento
    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;
    
    /**
     * Constructor que inicializa todos los atributos del cliente
     * 
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param rut RUT del cliente en formato XX.XXX.XXX-X
     * @param telefono Numero de telefono del cliente
     */
    public Cliente(String nombre, String apellido, String rut, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el nombre del cliente
     * 
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el apellido del cliente
     * 
     * @return Apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Obtiene el RUT del cliente
     * 
     * @return RUT del cliente
     */
    public String getRut() {
        return rut;
    }
    
    /**
     * Obtiene el telefono del cliente
     * 
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Muestra la informacion basica del cliente
     * Este metodo imprime en consola los datos personales del cliente
     */
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("RUT: " + rut);
        System.out.println("Telefono: " + telefono);
    }
    
    /**
     * Implementacion del metodo de la interfaz InfoCliente
     * Muestra informacion detallada del cliente en un formato especifico
     */
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("=== DATOS PERSONALES ===");
        System.out.println("Nombre completo: " + nombre + " " + apellido);
        System.out.println("RUT: " + rut);
        System.out.println("Telefono de contacto: " + telefono);
    }
}
