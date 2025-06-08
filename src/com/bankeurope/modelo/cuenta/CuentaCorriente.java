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
 * Clase que representa una cuenta corriente
 * Hereda de la clase abstracta Cuenta
 */
public class CuentaCorriente extends Cuenta implements InfoCliente {
    private double costoMantencion = 3500;
    
    // Constructor que llama al constructor de la clase padre
    public CuentaCorriente(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }
    
    // Constructor sobrecargado
    public CuentaCorriente(double saldo, Cliente cliente, double costoMantencion) {
        super(saldo, cliente);
        this.costoMantencion = costoMantencion;
    }

    // Sobreescritura del metodo mostrarInfo
    @Override
    public void mostrarInfo() {
        System.out.println("=== CUENTA CORRIENTE ===");
        super.mostrarInfo();
        System.out.println("Costo de mantencion mensual: $" + costoMantencion);
    }

    // Sobreescritura del metodo girar
    @Override
    public boolean girar(double monto) {
        System.out.println("Procesando giro desde cuenta corriente...");
        return super.girar(monto);
    }
    
    // Implementacion del metodo calcularMantencion
    public double calcularMantencion() {
        return costoMantencion;
    }
    
    // Implementacion del metodo abstracto
    @Override
    public double calcularInteres() {
        // Las cuentas corrientes no generan intereses
        return 0;
    }
    
    // Implementacion del metodo de la interfaz
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
