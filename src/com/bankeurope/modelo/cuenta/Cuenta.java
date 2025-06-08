/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.modelo.cuenta;

import com.bankeurope.modelo.cliente.Cliente;

/**
 * Clase abstracta que representa una cuenta bancaria generica
 * Contiene atributos y metodos comunes a todos los tipos de cuentas
 * Sirve como base para las clases especificas de cuentas bancarias
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public abstract class Cuenta {
    // Atributos protegidos para acceso desde subclases
    protected String numeroCuenta;
    protected double saldo;
    protected Cliente cliente;
    
    // Contador estatico para generar numeros de cuenta unicos
    private static int contadorCuentas = 1;

    /**
     * Constructor con dos parametros
     * Genera automaticamente un numero de cuenta unico
     * 
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     */
    public Cuenta(double saldo, Cliente cliente) {
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    /**
     * Constructor sobrecargado con tres parametros
     * Permite especificar un numero de cuenta existente
     * 
     * @param numeroCuenta Numero de cuenta especifico
     * @param saldo Saldo inicial de la cuenta
     * @param cliente Cliente asociado a la cuenta
     */
    public Cuenta(String numeroCuenta, double saldo, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Metodo privado para generar numero de cuenta
     * Utiliza un contador estatico para asegurar numeros unicos
     * 
     * @return Numero de cuenta formateado con ceros a la izquierda
     */
    private String generarNumeroCuenta() {
        String numero = String.format("%09d", contadorCuentas);
        contadorCuentas++;
        return numero;
    }

    /**
     * Obtiene el cliente asociado a la cuenta
     * 
     * @return Cliente asociado a la cuenta
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /**
     * Obtiene el numero de cuenta
     * 
     * @return Numero de cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    /**
     * Obtiene el saldo actual de la cuenta
     * 
     * @return Saldo actual
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Muestra el saldo actual de la cuenta
     * Imprime en consola el saldo disponible
     */
    public void consultarSaldo() {
        System.out.println("Saldo actual de la cuenta " + numeroCuenta + ": $" + saldo);
    }

    /**
     * Realiza un deposito en la cuenta
     * Aumenta el saldo si el monto es valido
     * 
     * @param monto Cantidad a depositar
     */
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Monto invalido. Debe ser mayor que cero.");
        }
    }

    /**
     * Realiza un giro desde la cuenta
     * Disminuye el saldo si hay fondos suficientes
     * 
     * @param monto Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
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

    /**
     * Muestra informacion basica de la cuenta
     * Imprime en consola los datos de la cuenta y del cliente
     */
    public void mostrarInfo() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        cliente.mostrarInfo();
    }
    
    /**
     * Metodo abstracto para calcular el interes de la cuenta
     * Debe ser implementado por todas las subclases
     * 
     * @return Monto de interes calculado
     */
    public abstract double calcularInteres();
}
