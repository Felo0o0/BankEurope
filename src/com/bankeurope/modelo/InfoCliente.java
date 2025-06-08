/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.modelo;

/**
 * Interfaz que define el comportamiento para mostrar informacion detallada del cliente
 * Esta interfaz es implementada por las clases que necesitan mostrar informacion
 * especifica del cliente asociado a diferentes tipos de cuentas bancarias.
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public interface InfoCliente {
    
    /**
     * Metodo que muestra informacion detallada del cliente
     * Cada clase que implemente esta interfaz debe proporcionar su propia
     * implementacion para mostrar la informacion relevante del cliente
     * segun el contexto especifico.
     */
    void mostrarInformacionCliente();
}
