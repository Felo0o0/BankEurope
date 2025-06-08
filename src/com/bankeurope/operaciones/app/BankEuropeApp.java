/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.bankeurope.operaciones.app;

import com.bankeurope.modelo.InfoCliente;
import com.bankeurope.modelo.cliente.Cliente;
import com.bankeurope.modelo.cuenta.Cuenta;
import com.bankeurope.modelo.cuenta.CuentaAhorro;
import com.bankeurope.modelo.cuenta.CuentaCorriente;
import com.bankeurope.modelo.cuenta.CuentaDigital;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que contiene el menu y la logica de la aplicacion
 * Gestiona la interaccion con el usuario y las operaciones bancarias
 * 
 * @author Bank Europe Development Team
 * @version 1.0
 */
public class BankEuropeApp {

    // Coleccion para almacenar las cuentas creadas
    static ArrayList<Cuenta> cuentas = new ArrayList<>();
    // Scanner para leer entrada del usuario
    static Scanner sc = new Scanner(System.in);

    /**
     * Metodo principal que inicia la aplicacion
     * Muestra el menu principal y gestiona las opciones seleccionadas
     * 
     * @param args Argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int opcion = 0;

        System.out.println("\n*** BIENVENIDO A BANK EUROPE ***");
        System.out.println("Su banco de confianza, siempre a su servicio");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Ver Datos Cliente");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Depositar");
            System.out.println("5. Girar");
            System.out.println("6. Ver Informacion Cliente");
            System.out.println("7. Calcular Intereses");
            System.out.println("8. Salir");
            System.out.print("Por favor, seleccione una opcion: ");
            
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                switch(opcion) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            verDatosCliente();
                        }
                        break;
                    case 3:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            consultarSaldo();
                        }
                        break;
                    case 4:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            depositar();
                        }
                        break;
                    case 5:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            girar();
                        }
                        break;
                    case 6:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            verInformacionCliente();
                        }
                        break;
                    case 7:
                        if(cuentas.isEmpty()) {
                            System.out.println("Aun no hay cuentas registradas. Le invitamos a crear una nueva cuenta.");
                        } else {
                            calcularIntereses();
                        }
                        break;
                    case 8:
                        System.out.println("Gracias por elegir Bank Europe. Esperamos verle pronto nuevamente.");
                        break;
                    default:
                        System.out.println("La opcion seleccionada no es valida. Por favor intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un numero valido.");
                sc.nextLine(); // Limpiar buffer en caso de error
                opcion = 0;
            }
        } while (opcion != 8);

        sc.close();
    }

    /**
     * Registra un nuevo cliente y crea una cuenta asociada
     * Solicita datos personales y tipo de cuenta a crear
     */
    private static void registrarCliente() {
        System.out.println("\n--- REGISTRO DE NUEVO CLIENTE ---");
        System.out.println("Nos complace darle la bienvenida a Bank Europe");
        
        System.out.print("Por favor, ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Por favor, ingrese su apellido: ");
        String apellido = sc.nextLine();

        String rut;
        while (true) {
            System.out.print("Por favor, ingrese su RUT (con puntos y guion): ");
            rut = sc.nextLine();
            if (validarRut(rut)) break;
            else System.out.println("El formato de RUT ingresado no es valido. Por favor intente nuevamente.");
        }

        System.out.print("Por favor, ingrese su telefono de contacto: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, rut, telefono);

        System.out.println("Que tipo de cuenta desea abrir con nosotros:");
        System.out.println("1. Cuenta Corriente - Ideal para sus operaciones diarias");
        System.out.println("2. Cuenta de Ahorro - La mejor opcion para hacer crecer su dinero");
        System.out.println("3. Cuenta Digital - La solucion moderna para sus finanzas");
        System.out.print("Por favor, seleccione una opcion (1-3): ");
        
        try {
            int tipo = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            
            System.out.print("Por favor, ingrese el saldo inicial para su cuenta: $");
            double saldoInicial = sc.nextDouble();
            sc.nextLine(); // Limpiar buffer

            switch (tipo) {
                case 1:
                    cuentas.add(new CuentaCorriente(saldoInicial, cliente));
                    break;
                case 2:
                    cuentas.add(new CuentaAhorro(saldoInicial, cliente));
                    break;
                case 3:
                    cuentas.add(new CuentaDigital(saldoInicial, cliente));
                    break;
                default:
                    System.out.println("La opcion seleccionada no es valida. No se ha creado ninguna cuenta.");
                    return;
            }

            Cuenta nuevaCuenta = cuentas.get(cuentas.size() - 1);
            System.out.println("Su cuenta ha sido creada exitosamente. Gracias por confiar en Bank Europe.");
            nuevaCuenta.mostrarInfo();
        } catch (Exception e) {
            System.out.println("Error: Por favor ingrese un valor numerico valido.");
            sc.nextLine(); // Limpiar buffer en caso de error
        }
    }

    /**
     * Muestra los datos basicos del cliente asociado a una cuenta
     * Permite seleccionar la cuenta cuyo cliente se desea consultar
     */
    private static void verDatosCliente() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            System.out.println("\nInformacion de cliente:");
            cuenta.getCliente().mostrarInfo();
        }
    }

    /**
     * Consulta el saldo de una cuenta seleccionada
     * Muestra el saldo actual disponible
     */
    private static void consultarSaldo() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            cuenta.consultarSaldo();
        }
    }

    /**
     * Realiza un deposito en una cuenta seleccionada
     * Solicita el monto a depositar
     */
    private static void depositar() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            try {
                System.out.print("Por favor, ingrese el monto a depositar: $");
                double monto = sc.nextDouble();
                sc.nextLine(); // Limpiar buffer
                cuenta.depositar(monto);
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un monto valido.");
                sc.nextLine(); // Limpiar buffer en caso de error
            }
        }
    }

    /**
     * Realiza un giro desde una cuenta seleccionada
     * Solicita el monto a girar
     */
    private static void girar() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            try {
                System.out.print("Por favor, ingrese el monto a girar: $");
                double monto = sc.nextDouble();
                sc.nextLine(); // Limpiar buffer
                cuenta.girar(monto);
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un monto valido.");
                sc.nextLine(); // Limpiar buffer en caso de error
            }
        }
    }
    
    /**
     * Muestra informacion detallada del cliente y su cuenta
     * Utiliza la interfaz InfoCliente para mostrar datos especificos
     */
    private static void verInformacionCliente() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            System.out.println("\n--- INFORMACION DEL CLIENTE ---");
            if (cuenta instanceof InfoCliente) {
                ((InfoCliente) cuenta).mostrarInformacionCliente();
            } else {
                System.out.println("No hay informacion detallada disponible para este tipo de cuenta.");
            }
        }
    }
    
    /**
     * Calcula y muestra los intereses generados por una cuenta
     * El calculo depende del tipo de cuenta seleccionada
     */
    private static void calcularIntereses() {
        Cuenta cuenta = seleccionarCuenta();
        if (cuenta != null) {
            double interes = cuenta.calcularInteres();
            System.out.println("El interes calculado para su cuenta es: $" + interes);
            
            if (cuenta instanceof CuentaAhorro) {
                System.out.println("Gracias por ahorrar con nosotros. Su dinero crece en Bank Europe.");
            } else if (cuenta instanceof CuentaDigital) {
                System.out.println("Su cuenta digital le brinda flexibilidad y beneficios. Gracias por elegir Bank Europe.");
            } else if (cuenta instanceof CuentaCorriente) {
                System.out.println("Su cuenta corriente le ofrece todas las ventajas para sus operaciones diarias.");
            }
        }
    }

    /**
     * Permite seleccionar una cuenta de la lista de cuentas registradas
     * Muestra un menu con las cuentas disponibles
     * 
     * @return La cuenta seleccionada o null si no se selecciona ninguna
     */
    private static Cuenta seleccionarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas en el sistema.");
            return null;
        }
        System.out.println("\nPor favor, seleccione una cuenta:");
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            System.out.println((i + 1) + ". " + c.getCliente().getNombre() + " " + c.getCliente().getApellido() + " - " + c.getClass().getSimpleName());
        }
        
        try {
            System.out.print("Su eleccion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            if (opcion < 1 || opcion > cuentas.size()) {
                System.out.println("La opcion seleccionada no es valida. Por favor intente nuevamente.");
                return null;
            }
            return cuentas.get(opcion - 1);
        } catch (Exception e) {
            System.out.println("Error: Por favor ingrese un numero valido.");
            sc.nextLine(); // Limpiar buffer en caso de error
            return null;
        }
    }

    /**
     * Valida el formato del RUT chileno
     * Verifica que el RUT tenga el formato XX.XXX.XXX-X
     * 
     * @param rut RUT a validar
     * @return true si el formato es valido, false en caso contrario
     */
    private static boolean validarRut(String rut) {
        return rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]");
    }
}
