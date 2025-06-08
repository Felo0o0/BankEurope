/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase que representa una cuenta digital bancaria
 * Hereda de la clase abstracta Cuenta e implementa la interfaz InfoCliente
 * Proporciona funcionalidades especificas para cuentas digitales
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class CuentaDigital extends Cuenta implements InfoCliente {
    // Atributos especificos de la cuenta digital
    private double tasaInteres = 0.015; // 1.5% de interes anual
    private boolean tarjetaVirtual = true;
    
    /**
     * Constructor que llama al constructor de la clase padre
     * Inicializa una cuenta digital con valores por defecto
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     */
    public CuentaDigital(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    /**
     * Constructor sobrecargado que permite especificar la tasa de interes
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     * @param tasaInteres Tasa de interes anual (en formato decimal, ej: 0.015 para 1.5%)
     */
    public CuentaDigital(double saldo, Cliente cliente, double tasaInteres) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
    }
    
    /**
     * Constructor sobrecargado con todos los parametros
     * Permite especificar todos los atributos de la cuenta digital
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     * @param tasaInteres Tasa de interes anual
     * @param tarjetaVirtual Indica si la cuenta tiene tarjeta virtual activa
     */
    public CuentaDigital(double saldo, Cliente cliente, double tasaInteres, boolean tarjetaVirtual) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
        this.tarjetaVirtual = tarjetaVirtual;
    }

    /**
     * Sobreescritura del metodo mostrarInfo
     * Muestra informacion especifica de la cuenta digital
     */
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA DIGITAL ===");
        super.mostrarInfo();
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
        System.out.println("Tarjeta virtual: " + (tarjetaVirtual ? "Activa" : "No disponible"));
    }

    /**
     * Sobreescritura del metodo girar
     * Agrega un mensaje especifico para giros desde cuenta digital
     * 
     * @param monto Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta digital...");
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
     * Las cuentas digitales tienen un costo de mantencion reducido
     * 
     * @return Costo de mantencion mensual
     */
    public double calcularMantencion() {
        // Las cuentas digitales tienen costo de mantencion reducido
        return 1500;
    }
    
    /**
     * Implementacion del metodo de la interfaz InfoCliente
     * Muestra informacion detallada del cliente y la cuenta digital
     */
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("=== INFORMACION DEL CLIENTE DE CUENTA DIGITAL ===");
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: Digital");
        System.out.println("Saldo disponible: $" + saldo);
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
        System.out.println("Interes proyectado anual: $" + calcularInteres());
        System.out.println("Tarjeta virtual: " + (tarjetaVirtual ? "Activa" : "No disponible"));
        System.out.println("Beneficios: Sin limite de transacciones, operaciones 100% online");
        cliente.mostrarInformacionCliente();
    }
}
