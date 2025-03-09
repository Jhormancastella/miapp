// package com.miapp;

// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.List;
// import java.util.Scanner;

// import com.miapp.application.usecase.client.ClientUseCase;
// import com.miapp.application.usecase.client.ProductUseCase;
// import com.miapp.domain.entity.Client;
// import com.miapp.domain.entity.Product;
// import com.miapp.domain.repository.ClientRespository;
// import com.miapp.domain.repository.ProductRepository;
// import com.miapp.infrastructure.database.ConnectionFactory;
// import com.miapp.infrastructure.persistence.Client.ClientRepositoryImpl;
// import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;

// public class Main {

//     public static void main(String[] args) {
//         ClientRespository clientRepository = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
//         ProductRepository productRepository = new ProductRepositoryImpl(ConnectionFactory.crearConexion());

//         ClientUseCase clientUseCase = new ClientUseCase(clientRepository);
//         ProductUseCase productUseCase = new ProductUseCase(productRepository);

        // // Comprobación de conexión a la base de datos
        // try (Connection conexion = ConnectionFactory.crearConexion().getConexion()) {
        //     if (conexion != null) {
        //         System.out.println("\n**************************************************");
        //         System.out.println("\n!!! Conectado a la base de datos exitosamente. !!!");
        //         System.out.println("\n**************************************************");

                
        //         // detalle visual limpiar y pusa para leer 

        //         // Esperar 5 segundos (5000 milisegundos) 

        //         Thread.sleep(5000);

        //         // Limpiar la consola 

        //         limpiarConsola();

        //         System.out.println("\nIniciando menú principal...");

        //         // Esperar 3 segundos (3000 milisegundos) 

        //         Thread.sleep(3000);

        //         // Limpiar la consola
        //         limpiarConsola();

        //     } else {
        //         // Salir si no hay conexión
        //         System.out.println("No se pudo conectar a la base de datos.");
        //         return;
        //     }
        // } catch (SQLException e) {
        //     // Salir si hay un error en la conexión
        //     System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        //     return;
        // } catch (InterruptedException e) {
        //     System.out.println("Error en la pausa: " + e.getMessage());
        //     return;
        // }

//         try (Scanner sc = new Scanner(System.in)) {
//             int option;
//             do {
//                 System.out.println("\n==============================");
//                 System.out.println("        Menú Principal        ");
//                 System.out.println("==============================");
//                 System.out.println("1. Gestionar Clientes");
//                 System.out.println("2. Gestionar Productos");
//                 System.out.println("3. Listar Clientes");
//                 System.out.println("4. Listar Productos");
//                 System.out.println("0. Salir");
//                 System.out.print("Ingrese su opción: ");
//                 option = sc.nextInt();

//                 sc.nextLine(); // Consumir la nueva línea

//                 limpiarConsola();

//                 switch (option) {
//                     case 1:
//                         gestionarClientes(sc, clientUseCase);
//                         break;
//                     case 2:
//                         gestionarProductos(sc, productUseCase);
//                         break;
//                     case 3:
//                         listarClientes(clientUseCase);
//                         break;
//                     case 4:
//                         listarProductos(productUseCase);
//                         break;
//                     case 0:
//                         System.out.println("Saliendo...");
//                         break;
//                     default:
//                         System.out.println("Opción no válida. Intente nuevamente.");
//                         break;
//                 }
//             } while (option != 0);
//         }
//     }

//     private static void gestionarClientes(Scanner sc, ClientUseCase clientUseCase) {
//         int clientOption;
//         do {
//             System.out.println("\n---- Gestión de Clientes ----");
//             System.out.println("1. Registrar Cliente");
//             System.out.println("2. Actualizar Cliente");
//             System.out.println("3. Eliminar Cliente");
//             System.out.println("0. Volver al Menú Principal");
//             System.out.print("Ingrese su opción: ");
//             clientOption = sc.nextInt();
//             sc.nextLine(); // Consumir la nueva línea
//             limpiarConsola();
//             switch (clientOption) {
//                 case 1:
//                     System.out.print("Ingrese ID del Cliente: ");
//                     int id = sc.nextInt();
//                     sc.nextLine(); 

//                     System.out.print("Ingrese Nombre: ");
//                     String nombre = sc.nextLine();
//                     System.out.print("Ingrese Email: ");
//                     String email = sc.nextLine();
//                     clientUseCase.registrarCliente(id, nombre, email);
//                     System.out.println("Cliente registrado exitosamente.");
//                     break;
//                 case 2:
//                     System.out.print("Ingrese ID del Cliente a actualizar: ");
//                     int idActualizar = sc.nextInt();
//                     sc.nextLine(); 

//                     System.out.print("Ingrese Nuevo Nombre: ");
//                     String nuevoNombre = sc.nextLine();
//                     System.out.print("Ingrese Nuevo Email: ");
//                     String nuevoEmail = sc.nextLine();
//                     clientUseCase.actualizarCliente(idActualizar, nuevoNombre, nuevoEmail);
//                     System.out.println("Cliente actualizado exitosamente.");
//                     break;
//                 case 3:
//                     System.out.print("Ingrese ID del Cliente a eliminar: ");
//                     int idEliminar = sc.nextInt();
//                     clientUseCase.eliminarCliente(idEliminar);
//                     System.out.println("Cliente eliminado exitosamente.");
//                     break;
//                 case 0:
//                     System.out.println("Volviendo al Menú Principal...");
//                     break;
//                 default:
//                     System.out.println("Opción no válida. Intente nuevamente.");
//                     break;
//             }
//         } while (clientOption != 0);
//     }

//     private static void gestionarProductos(Scanner sc, ProductUseCase productUseCase) {
//         int productOption;
//         do {
//             System.out.println("\n---- Gestión de Productos ----");
//             System.out.println("1. Registrar Producto");
//             System.out.println("2. Actualizar Producto");
//             System.out.println("3. Eliminar Producto");
//             System.out.println("0. Volver al Menú Principal");
//             System.out.print("Ingrese su opción: ");
//             productOption = sc.nextInt();
//             sc.nextLine();

//             limpiarConsola();
//             switch (productOption) {
//                 case 1:
//                     System.out.print("Ingrese ID del Producto: ");
//                     int productId = sc.nextInt();
//                     sc.nextLine(); 
//                     System.out.print("Ingrese Nombre del Producto: ");
//                     String productName = sc.nextLine();
//                     System.out.print("Ingrese Stock del Producto: ");
//                     int stock = sc.nextInt();

//                     productUseCase.registrarProducto(productId, productName, stock);
//                     System.out.println("Producto registrado exitosamente.");
//                     break;
//                 case 2:
//                     System.out.print("Ingrese ID del Producto a actualizar: ");
//                     int idProductoActualizar = sc.nextInt();
//                     sc.nextLine(); 

//                     System.out.print("Ingrese Nuevo Nombre: ");
//                     String nuevoProductoNombre = sc.nextLine();
//                     System.out.print("Ingrese Nuevo Stock: ");
//                     int nuevoStock = sc.nextInt();
//                     productUseCase.actualizarProducto(idProductoActualizar, nuevoProductoNombre, nuevoStock);
//                     System.out.println("Producto actualizado exitosamente.");
//                     break;
//                 case 3:
//                     System.out.print("Ingrese ID del Producto a eliminar: ");
//                     int idProductoEliminar = sc.nextInt();
//                     productUseCase.eliminarProducto(idProductoEliminar);
//                     System.out.println("Producto eliminado exitosamente.");
//                     break;
//                 case 0:
//                     System.out.println("Volviendo al Menú Principal...");
//                     break;
//                 default:
//                     System.out.println("Opción no válida. Intente nuevamente.");
//                     break;
//             }
//         } while (productOption != 0);
//     }

//     private static void listarClientes(ClientUseCase clientUseCase) {
//         List<Client> clientes = clientUseCase.listarClientes();
//         System.out.println("\nLista de Clientes:");
//         for (Client cliente : clientes) {
//             System.out.println(cliente);
//         }
//     }

//     private static void listarProductos(ProductUseCase productUseCase) {
//         List<Product> productos = productUseCase.listarProductos();
//         System.out.println("\nLista de Productos:");
//         for (Product producto : productos) {
//             System.out.println(producto);
//         }
//     }

//     // esta seccion se agrego para limpiar consola o terminal.// 

//     private static void limpiarConsola() {
//         try {
//             // Intenta limpiar la consola en sistemas Windows
//             new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//         } catch (Exception e) {
//             try {
//                 // Intenta limpiar la consola en sistemas Unix/Linux/Mac
//                 new ProcessBuilder("clear").inheritIO().start().waitFor();
//             } catch (Exception ex) {
//                 // Si no se puede limpiar la consola, simplemente imprime varias líneas en blanco
//                 for (int i = 0; i < 50; i++) {
//                     System.out.println();
//                 }
//             }
//         }
//     }
// }

package com.miapp;

import com.miapp.application.usecase.client.ClientUseCase;
import com.miapp.application.usecase.client.ProductUseCase;
import com.miapp.domain.repository.ClientRespository;
import com.miapp.domain.repository.ProductRepository;
import com.miapp.infrastructure.database.ConnectionFactory;
import com.miapp.infrastructure.persistence.Client.ClientRepositoryImpl;
import com.miapp.infrastructure.persistence.product.ProductRepositoryImpl;
import com.miapp.menu.ClientMenu;
import com.miapp.menu.ProductMenu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

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
                Thread.sleep(5000); // Esperar 5 segundos
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