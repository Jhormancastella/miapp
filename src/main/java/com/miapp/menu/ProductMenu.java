package com.miapp.menu;

import com.miapp.application.usecase.client.ProductUseCase;
import com.miapp.domain.entity.Product;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
    private final ProductUseCase productUseCase;
    private final Scanner sc;

    public ProductMenu(ProductUseCase productUseCase, Scanner sc) {
        this.productUseCase = productUseCase;
        this.sc = sc;
    }

    public void gestionarProductos() {
        int productOption;
        do {
            System.out.println("\n---- Gestión de Productos ----");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            productOption = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            limpiarConsola();

            switch (productOption) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    actualizarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (productOption != 0);
    }

    private void registrarProducto() {
        System.out.print("Ingrese ID del Producto: ");
        int productId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese Nombre del Producto: ");
        String productName = sc.nextLine();
        System.out.print("Ingrese Stock del Producto: ");
        int stock = sc.nextInt();
        productUseCase.registrarProducto(productId, productName, stock);
        System.out.println("Producto registrado exitosamente.");
    }

    private void actualizarProducto() {
        System.out.print("Ingrese ID del Producto a actualizar: ");
        int idProductoActualizar = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese Nuevo Nombre: ");
        String nuevoProductoNombre = sc.nextLine();
        System.out.print("Ingrese Nuevo Stock: ");
        int nuevoStock = sc.nextInt();
        productUseCase.actualizarProducto(idProductoActualizar, nuevoProductoNombre, nuevoStock);
        System.out.println("Producto actualizado exitosamente.");
    }

    private void eliminarProducto() {
        System.out.print("Ingrese ID del Producto a eliminar: ");
        int idProductoEliminar = sc.nextInt();
        productUseCase.eliminarProducto(idProductoEliminar);
        System.out.println("Producto eliminado exitosamente.");
    }

    public void listarProductos() {
        // Obtener la lista de productos desde el caso de uso
        
        List<Product> productos = productUseCase.listarProductos();
    
        // Verificar si la lista está vacía

        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos registrados.");
            System.out.println("Por favor, ingrese productos para poder listarlos.");
        } else {
            // Si hay productos, mostrarlos en formato de tabla
            System.out.println("\nLista de Productos:");
            System.out.println("+------+----------------------+------------+");
            System.out.println("|  ID  |  Nombre              |   Stock    |");
            System.out.println("+------+----------------------+------------+");
    
            for (Product producto : productos) {
                System.out.println(producto); // Usa el método toString() de la clase Product
            }
    
            System.out.println("+------+----------------------+------------+");
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