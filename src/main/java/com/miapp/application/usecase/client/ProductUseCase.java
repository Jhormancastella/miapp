package com.miapp.application.usecase.client;

import java.util.List;

import com.miapp.domain.entity.Product;
import com.miapp.domain.repository.ProductRepository;

public class ProductUseCase {
    
    private final ProductRepository repository;

    public ProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void registrarProducto(int productId, String productName, int stock) {
        Product producto = new Product(productId, productName, stock);
        repository.guardar(producto);
    }
    
    public Product obtenerProducto(int id) {
        return repository.buscarPorId(id);
    }

    public List<Product> listarProductos() {
        return repository.listarTodos();
    }

    public void actualizarProducto(int productId, String productName, int stock) {
        Product producto = new Product(productId, productName, stock);
        repository.actualizar(producto);
    }

    public void eliminarProducto(int id) {
        repository.eliminar(id);
    }

    public boolean existeProducto(int id) {
        return repository.buscarPorId(id) != null;
    }
}