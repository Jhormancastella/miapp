package com.miapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.application.usecase.client.ProductUseCase;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.domain.repository.ProductRepository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.infrastructure.persistence.client.ClientRepositoryImpl;
import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;
import com.miapp.menu.ClientMenu;
import com.miapp.menu.ProductMenu;

public class Main {

    public static void main(String[] args) {
        ClientRespository clientRepository = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ProductRepository productRepository = new ProductRepositoryImpl(ConnectionFactory.crearConexion());

        ClientUseCase clientUseCase = new ClientUseCase(clientRepository);
        ProductUseCase productUseCase = new ProductUseCase(productRepository);

        // Comprobación de conexión a la base de datos

        try (Connection conexion = ConnectionFactory.crearConexion().getConexion()) {
            if (conexion != null) {
                System.out.println("\n**************************************************");
                System.out.println("\n!!! Conectado a la base de datos exitosamente. !!!");
                System.out.println("\n**************************************************");

                // Detalle visual: limpiar consola y pausa
                
                Thread.sleep(3000); // Esperar 5 segundos
                limpiarConsola();  // Limpiar la consola

                System.out.println("\nIniciando menú principal...");

                Thread.sleep(2000); // Esperar 2 segundos
                limpiarConsola();  // Limpiar la consola

            } else {
                // Salir si no hay conexión
                System.out.println("No se pudo conectar a la base de datos.");
                return;
            }
        } catch (SQLException e) {
            // Salir si hay un error en la conexión
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return;
        } catch (InterruptedException e) {
            System.out.println("Error en la pausa: " + e.getMessage());
            return;
        }
        System.out.println("\n usar siempre los caracteres indicados por los campos ");

        try (Scanner sc = new Scanner(System.in)) {
            // Crear instancias de los menús
            ClientMenu clientMenu = new ClientMenu(clientUseCase, sc);
            
            ProductMenu productMenu = new ProductMenu(productUseCase, sc);

            int option;
            do {
                System.out.println("\n==============================");
                System.out.println("        Menú Principal        ");
                System.out.println("==============================");
                System.out.println("1. Gestionar Clientes");
                System.out.println("2. Gestionar Productos");
                System.out.println("3. Listar Clientes");
                System.out.println("4. Listar Productos");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opción: ");
               
                while (!sc.hasNextInt()) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    sc.next(); 
                    // Limpiar el valor incorrecto del scanner
                    System.out.print("Ingrese su opción: ");
                }
                
                option = sc.nextInt();

                sc.nextLine(); // Consumir la nueva línea

                limpiarConsola(); // Limpiar la consola antes de mostrar el submenú

                switch (option) {
                    case 1:
                        clientMenu.gestionarClientes();
                        break;
                    case 2:
                        productMenu.gestionarProductos();
                        break;
                    case 3:
                        clientMenu.listarClientes();
                        break;
                    case 4:
                        productMenu.listarProductos();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } while (option != 0);
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















