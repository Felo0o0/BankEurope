/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase que representa una cuenta de ahorro bancaria
 * Hereda de la clase abstracta Cuenta e implementa la interfaz InfoCliente
 * Proporciona funcionalidades especificas para cuentas de ahorro
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class CuentaAhorro extends Cuenta implements InfoCliente {
    // Atributo especifico de la cuenta de ahorro
    private double tasaInteres = 0.02; // 2% de interes anual
    
    /**
     * Constructor que llama al constructor de la clase padre
     * Inicializa una cuenta de ahorro con la tasa de interes por defecto
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     */
    public CuentaAhorro(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    /**
     * Constructor sobrecargado que permite especificar la tasa de interes
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     * @param tasaInteres Tasa de interes anual (en formato decimal, ej: 0.02 para 2%)
     */
    public CuentaAhorro(double saldo, Cliente cliente, double tasaInteres) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
    }

    /**
     * Sobreescritura del metodo mostrarInfo
     * Muestra informacion especifica de la cuenta de ahorro
     */
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA DE AHORRO ===");
        super.mostrarInfo();
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
    }

    /**
     * Sobreescritura del metodo girar
     * Agrega un mensaje especifico para giros desde cuenta de ahorro
     * 
     * @param monto Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta de ahorro...");
        // Limitar a 3 giros mensuales (simulado)
        return super.girar(monto);
    }
    
    /**
     * Implementacion del metodo abstracto calcularInteres
     * Calcula el interes anual basado en el saldo actual y la tasa de interes
     * 
     * @return Monto de interes anual calculado
     */
    @Override
    public double calcularInteres() {
        return saldo * tasaInteres;
    }
    
    /**
     * Calcula el costo de mantencion mensual de la cuenta
     * Las cuentas de ahorro no tienen costo de mantencion
     * 
     * @return 0, ya que las cuentas de ahorro no tienen costo de mantencion
     */
    public double calcularMantencion() {
        // Las cuentas de ahorro no tienen costo de mantencion
        return 0;
    }
    
    /**
     * Implementacion del metodo de la interfaz InfoCliente
     * Muestra informacion detallada del cliente y la cuenta de ahorro
     */
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("=== INFORMACION DEL CLIENTE DE CUENTA DE AHORRO ===");
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: Ahorro");
        System.out.println("Saldo disponible: $" + saldo);
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
        System.out.println("Interes proyectado anual: $" + calcularInteres());
        System.out.println("Restricciones: Maximo 3 giros mensuales");
        cliente.mostrarInformacionCliente();
    }
}
