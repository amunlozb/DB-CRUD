package com.angel.db.model;

public class Product {
    private String nombre;
    private String descripcion;
    private Double peso;
    private Integer stock;

    public Product() {
    }

    public Product(String nombre, String descripcion, Double peso, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peso = peso;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", stock=" + stock +
                '}';
    }
}
