package com.miapp.menu;

import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.domain.entity.Client;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    private final ClientUseCase clientUseCase;
    private final Scanner sc;

    public ClientMenu(ClientUseCase clientUseCase, Scanner sc) {
        this.clientUseCase = clientUseCase;
        this.sc = sc;
    }

    public void gestionarClientes() {
        int clientOption;
        do {
            System.out.println("\n---- Gestión de Clientes ----");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            
            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.next(); // Limpiar el valor incorrecto del scanner
                System.out.print("Ingrese su opción: ");
            }
            
            clientOption = sc.nextInt();
            sc.nextLine(); 

            limpiarConsola();

            switch (clientOption) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    actualizarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (clientOption != 0);
    }

    private void registrarCliente() {
        System.out.print("Ingrese ID del Cliente: ");
        while (!sc.hasNextInt()) {
            System.out.println("ID no válido. Por favor, ingrese un número.");
            sc.next(); // Limpiar el valor incorrecto del scanner
            System.out.print("Ingrese ID del Cliente: ");
        }
        int id = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea
    
        // Verificar si el ID ya existe
        if (clientUseCase.existeCliente(id)) {
            System.out.println("Error: El ID ya está en uso. No se puede registrar el cliente.");
            return; // Salir del método si el ID ya existe
        }
    
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        while (!Validaciones.esTextoValido(nombre)) {
            System.out.println("Nombre no válido. Solo se permiten letras y espacios.");
            System.out.print("Ingrese Nombre: ");
            nombre = sc.nextLine();
        }
    
        System.out.print("Ingrese Email: ");
        String email = sc.nextLine();
        while (!Validaciones.esEmailValido(email)) {
            System.out.println("Email no válido. Por favor, ingrese un email válido.");
            System.out.print("Ingrese Email: ");
            email = sc.nextLine();
        }
    
        try {
            clientUseCase.registrarCliente(id, nombre, email);
            System.out.println("Cliente registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }
    }

    private void actualizarCliente() {
        System.out.print("Ingrese ID del Cliente a actualizar: ");
        while (!sc.hasNextInt()) {
            System.out.println("ID no válido. Por favor, ingrese un número.");
            sc.next(); // Limpiar el valor incorrecto del scanner
            System.out.print("Ingrese ID del Cliente a actualizar: ");
        }
        int idActualizar = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea
    
        // Verificar si el ID existe
        if (!clientUseCase.existeCliente(idActualizar)) {
            System.out.println("Error: El ID no existe. No se puede actualizar el cliente.");
            return; // Salir del método si el ID no existe
        }
    
        System.out.print("Ingrese Nuevo Nombre: ");
        String nuevoNombre = sc.nextLine();
        while (!Validaciones.esTextoValido(nuevoNombre)) {
            System.out.println("Nombre no válido. Solo se permiten letras y espacios.");
            System.out.print("Ingrese Nuevo Nombre: ");
            nuevoNombre = sc.nextLine();
        }
    
        System.out.print("Ingrese Nuevo Email: ");
        String nuevoEmail = sc.nextLine();
        while (!Validaciones.esEmailValido(nuevoEmail)) {
            System.out.println("Email no válido. Por favor, ingrese un email válido.");
            System.out.print("Ingrese Nuevo Email: ");
            nuevoEmail = sc.nextLine();
        }
    
        try {
            clientUseCase.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
            System.out.println("Cliente actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    private void eliminarCliente() {
        System.out.print("\nIngrese ID del Cliente a eliminar: ");
        while (!sc.hasNextInt()) {
            System.out.println("ID no válido. Por favor, ingrese un número.");
            sc.next(); // Limpiar el valor incorrecto del scanner
            System.out.print("Ingrese ID del Cliente a eliminar: ");
        }
        int idEliminar = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea
    
        // Verificar si el ID existe
        if (!clientUseCase.existeCliente(idEliminar)) {
            System.out.println("Error: El ID no existe. No se puede eliminar el cliente.");
            return; // Salir del método si el ID no existe
        }
    
        try {
            clientUseCase.eliminarCliente(idEliminar);
            System.out.println("\nCliente eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    public void listarClientes() {
        // Obtener la lista de clientes desde el caso de uso
        List<Client> clientes = clientUseCase.listarClientes();
    
        // Verificar si la lista está vacía
        if (clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.");
            System.out.println("Por favor, ingrese clientes para poder listarlos.");
        } else {
            // Si hay clientes, mostrarlos en formato de tabla
            System.out.println("\nLista de Clientes:");
            System.out.println("+------+----------------------+--------------------------------+");
            System.out.println("|  ID  |        Nombre        |             Email              |");
            System.out.println("+------+----------------------+--------------------------------+");
    
            for (Client cliente : clientes) {
                System.out.println(cliente); // Usa el método toString() de la clase Client
            
    
            System.out.println("+------+----------------------+--------------------------------+");
            }
        }
    }
    
    // Método para limpiar la consola

    private static void limpiarConsola() {
        try {
            // Intenta limpiar la consola en sistemas Windows

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            try {
                // Intenta limpiar la consola en sistemas Unix/Linux/Mac

                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception ex) {
                
                // Si no se puede limpiar la consola, simplemente imprime varias líneas en blanco

                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            }
        }
    }
}