/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * @author felix
 */

package com.bankeurope.operaciones.transacciones;

import com.bankeurope.modelo.cuenta.Cuenta;
import java.util.Date;

/**
 * Clase para gestionar las transacciones bancarias
 */
public class GestorTransacciones {
    
    /**
     * Registra una transaccion de deposito
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
     */
    private void registrarTransaccion(String tipo, Cuenta cuenta, double monto) {
        Date fecha = new Date();
        System.out.println("Transaccion registrada: " + tipo + " de $" + monto);
        System.out.println("Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Cliente: " + cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
        System.out.println("Fecha: " + fecha);
    }
}
