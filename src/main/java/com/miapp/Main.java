package com.miapp;

import java.util.List;
import java.util.Scanner;

import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.application.usecase.client.ProductUseCase;
import com.miapp.domain.entity.Client;
import com.miapp.domain.entity.Product;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.domain.repository.ProductRepository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.infrastructure.persistence.client.ClientRepositoryImpl;
import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository clientRepository = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ProductRepository productRepository = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        
        ClientUseCase clientUseCase = new ClientUseCase(clientRepository);
        ProductUseCase productUseCase = new ProductUseCase(productRepository);

        try (Scanner sc = new Scanner(System.in)) {
            int option;
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Gestionar Clientes");
                System.out.println("2. Listar Clientes");
                System.out.println("3. Gestionar Productos");
                System.out.println("4. Listar Productos");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opción: ");
                option = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea

                switch (option) {
                    case 1:
                        // Gestión de Clientes
                        System.out.print("Ingrese ID del Cliente: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese Email: ");
                        String email = sc.nextLine();
                        clientUseCase.registrarCliente(id, nombre, email);
                        System.out.println("✅ Cliente registrado exitosamente.");
                        break;

                    case 2:
                        // Listar Clientes
                        List<Client> clientes = clientUseCase.listarClientes();
                        System.out.println("Lista de Clientes:");
                        for (Client cliente : clientes) {
                            System.out.println(cliente);
                        }
                        break;

                    case 3:
                        // Gestión de Productos
                        System.out.print("Ingrese ID del Producto: ");
                        int productId = sc.nextInt();
                        sc.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese Nombre del Producto: ");
                        String productName = sc.nextLine();
                        System.out.print("Ingrese Stock del Producto: ");
                        int stock = sc.nextInt();
                        productUseCase.registrarProducto(productId, productName, stock);
                        System.out.println("✅ Producto registrado exitosamente.");
                        break;

                    case 4:
                        // Listar Productos
                        List<Product> productos = productUseCase.listarProductos();
                        System.out.println("Lista de Productos:");
                        for (Product producto : productos) {
                            System.out.println(producto);
                        }
                        break;

                    case 0:
                        System.out.println("👋 Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } while (option != 0);
        }
    }
}