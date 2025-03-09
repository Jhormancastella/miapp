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
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Email: ");
        String email = sc.nextLine();
        clientUseCase.registrarCliente(id, nombre, email);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void actualizarCliente() {
        System.out.print("Ingrese ID del Cliente a actualizar: ");
        int idActualizar = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese Nuevo Nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Ingrese Nuevo Email: ");
        String nuevoEmail = sc.nextLine();
        clientUseCase.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
        System.out.println("Cliente actualizado exitosamente.");
    }

    private void eliminarCliente() {
        System.out.print("\nIngrese ID del Cliente a eliminar: ");
        int idEliminar = sc.nextInt();
        clientUseCase.eliminarCliente(idEliminar);
        System.out.println("\nCliente eliminado exitosamente.");
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