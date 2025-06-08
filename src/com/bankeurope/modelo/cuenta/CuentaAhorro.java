/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * @author felix
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase que representa una cuenta de ahorro
 * Hereda de la clase abstracta Cuenta
 */
public class CuentaAhorro extends Cuenta implements InfoCliente {
    private double tasaInteres = 0.02; // 2% de interes anual
    
    // Constructor que llama al constructor de la clase padre
    public CuentaAhorro(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    // Constructor sobrecargado
    public CuentaAhorro(double saldo, Cliente cliente, double tasaInteres) {
        super(saldo, cliente);
        this.tasaInteres = tasaInteres;
    }

    // Sobreescritura del metodo mostrarInfo
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA DE AHORRO ===");
        super.mostrarInfo();
        System.out.println("Tasa de interes anual: " + (tasaInteres * 100) + "%");
    }

    // Sobreescritura del metodo girar
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta de ahorro...");
        // Limitar a 3 giros mensuales (simulado)
        return super.girar(monto);
    }
    
    // Implementacion del metodo abstracto
    @Override
    public double calcularInteres() {
        return saldo * tasaInteres;
    }
    
    // Metodo para calcular mantencion
    public double calcularMantencion() {
        // Las cuentas de ahorro no tienen costo de mantencion
        return 0;
    }
    
    // Implementacion del metodo de la interfaz
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
