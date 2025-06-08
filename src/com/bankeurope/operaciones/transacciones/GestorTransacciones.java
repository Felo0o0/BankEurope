/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.operaciones.transacciones;

import com.bankeurope.modelo.cuenta.Cuenta;
import java.util.Date;

/**
 * Clase para gestionar las transacciones bancarias
 * Proporciona metodos para registrar y procesar diferentes tipos de transacciones
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class GestorTransacciones {
    
    /**
     * Registra una transaccion de deposito
     * Valida el monto y realiza el deposito en la cuenta especificada
     * 
     * @param cuenta La cuenta donde se realiza el deposito
     * @param monto El monto del deposito
     * @return true si la transaccion se completa con exito
     */
    public boolean registrarDeposito(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor que cero");
            return false;
        }
        
        cuenta.depositar(monto);
        registrarTransaccion("Deposito", cuenta, monto);
        return true;
    }
    
    /**
     * Registra una transaccion de giro
     * Valida el monto y realiza el giro desde la cuenta especificada
     * 
     * @param cuenta La cuenta de donde se realiza el giro
     * @param monto El monto del giro
     * @return true si la transaccion se completa con exito
     */
    public boolean registrarGiro(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor que cero");
            return false;
        }
        
        if (cuenta.girar(monto)) {
            registrarTransaccion("Giro", cuenta, monto);
            return true;
        }
        return false;
    }
    
    /**
     * Metodo privado para registrar los detalles de una transaccion
     * Guarda informacion sobre el tipo, cuenta, monto y fecha de la transaccion
     * 
     * @param tipo Tipo de transaccion (Deposito, Giro, etc.)
     * @param cuenta Cuenta involucrada en la transaccion
     * @param monto Monto de la transaccion
     */
    private void registrarTransaccion(String tipo, Cuenta cuenta, double monto) {
        Date fecha = new Date();
        System.out.println("Transaccion registrada: " + tipo + " de $" + monto);
        System.out.println("Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Cliente: " + cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
        System.out.println("Fecha: " + fecha);
    }
}
