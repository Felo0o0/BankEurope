/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase que representa una cuenta corriente bancaria
 * Hereda de la clase abstracta Cuenta e implementa la interfaz InfoCliente
 * Proporciona funcionalidades especificas para cuentas corrientes
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class CuentaCorriente extends Cuenta implements InfoCliente {
    // Atributo especifico de la cuenta corriente
    private double costoMantencion = 3500;
    
    /**
     * Constructor que llama al constructor de la clase padre
     * Inicializa una cuenta corriente con el costo de mantencion por defecto
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     */
    public CuentaCorriente(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    /**
     * Constructor sobrecargado que permite especificar el costo de mantencion
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     * @param costoMantencion Costo mensual de mantencion de la cuenta
     */
    public CuentaCorriente(double saldo, Cliente cliente, double costoMantencion) {
        super(saldo, cliente);
        this.costoMantencion = costoMantencion;
    }

    /**
     * Sobreescritura del metodo mostrarInfo
     * Muestra informacion especifica de la cuenta corriente
     */
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA CORRIENTE ===");
        super.mostrarInfo();
        System.out.println("Costo de mantencion mensual: $" + costoMantencion);
    }

    /**
     * Sobreescritura del metodo girar
     * Agrega un mensaje especifico para giros desde cuenta corriente
     * 
     * @param monto Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta corriente...");
        return super.girar(monto);
    }
    
    /**
     * Calcula el costo de mantencion mensual de la cuenta
     * 
     * @return Costo de mantencion mensual
     */
    public double calcularMantencion() {
        return costoMantencion;
    }
    
    /**
     * Implementacion del metodo abstracto calcularInteres
     * Las cuentas corrientes no generan intereses
     * 
     * @return 0, ya que las cuentas corrientes no generan intereses
     */
    @Override
    public double calcularInteres() {
        // Las cuentas corrientes no generan intereses
        return 0;
    }
    
    /**
     * Implementacion del metodo de la interfaz InfoCliente
     * Muestra informacion detallada del cliente y la cuenta corriente
     */
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("=== INFORMACION DEL CLIENTE DE CUENTA CORRIENTE ===");
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: Corriente");
        System.out.println("Saldo disponible: $" + saldo);
        System.out.println("Costo de mantencion mensual: $" + costoMantencion);
        System.out.println("Beneficios: Tarjeta de debito, chequera");
        cliente.mostrarInformacionCliente();
    }
}
