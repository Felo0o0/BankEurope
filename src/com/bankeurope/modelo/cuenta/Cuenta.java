/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author felix
 * @author pau rojas
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase abstracta que representa una cuenta bancaria generica
 * Contiene atributos y metodos comunes a todos los tipos de cuentas
 */
public abstract class Cuenta {
    // Atributos protegidos para acceso desde subclases
    protected String numeroCuenta;
    protected double saldo;
    protected Cliente cliente;
    
    // Contador estatico para generar numeros de cuenta unicos
    private static int contadorCuentas = 1;

    // Constructor con dos parametros
    public Cuenta(double saldo, Cliente cliente) {
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    // Constructor sobrecargado con tres parametros
    public Cuenta(String numeroCuenta, double saldo, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    // Metodo privado para generar numero de cuenta
    private String generarNumeroCuenta() {
        String numero = String.format("%09d", contadorCuentas);
        contadorCuentas++;
        return numero;
    }

    // Metodo para obtener el cliente asociado a la cuenta
    public Cliente getCliente() {
        return cliente;
    }
    
    // Metodo para obtener el numero de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    // Metodo para obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    // Metodo para consultar saldo
    public void consultarSaldo() {
        System.out.println("Saldo actual de la cuenta " + numeroCuenta + ": $" + saldo);
    }

    // Metodo para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Monto invalido. Debe ser mayor que cero.");
        }
    }

    // Metodo para girar dinero
    public boolean girar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Giro exitoso. Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente o monto invalido.");
            return false;
        }
    }

    // Metodo para mostrar informacion basica de la cuenta
    public void mostrarInfo() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        cliente.mostrarInfo();
    }
    
    // Metodo abstracto que debe ser implementado por las subclases
    public abstract double calcularInteres();
}