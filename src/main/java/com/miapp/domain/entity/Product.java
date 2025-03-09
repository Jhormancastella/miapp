package com.miapp.domain.entity;

public class Product {
    private int id;
    private String name;
    private int stock;

    // Constructor

    public Product(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock; 
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() { 
        return stock;
    }

    public void setStock(int stock) { 
        this.stock = stock;
    }
    
    
// Método toString para darle un mejor formato en consola 

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-10d |", id, name, stock);
    }
}