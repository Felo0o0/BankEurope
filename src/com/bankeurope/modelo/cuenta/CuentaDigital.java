/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/**
 * 
 * @author felix
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase que representa una cuenta digital
 * Hereda de la clase abstracta Cuenta
 */
public class CuentaDigital extends Cuenta implements InfoCliente {
    private double tasaInteres = 0.015; // 1.5% de interes anual
    private boolean tarjetaVirtual = true;
    
    // Constructor que llama al constructor de la clase padre
    public CuentaDigital(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    // Constructor sobrecargado
    public CuentaDigital(double saldo, Cliente cliente, double tasaInteres) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
    }
    
    // Constructor sobrecargado con todos los parametros
    public CuentaDigital(double saldo, Cliente cliente, double tasaInteres, boolean tarjetaVirtual) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
        this.tarjetaVirtual = tarjetaVirtual;
    }

    // Sobreescritura del metodo mostrarInfo
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA DIGITAL ===");
        super.mostrarInfo();
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
        System.out.println("Tarjeta virtual: " + (tarjetaVirtual ? "Activa" : "No disponible"));
    }

    // Sobreescritura del metodo girar
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta digital...");
        return super.girar(monto);
    }
    
    // Implementacion del metodo abstracto
    @Override
    public double calcularInteres() {
        return saldo * tasaInteres;
    }
    
    // Metodo para calcular mantencion
    public double calcularMantencion() {
        // Las cuentas digitales tienen costo de mantencion reducido
        return 1500;
    }
    
    // Implementacion del metodo de la interfaz
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
