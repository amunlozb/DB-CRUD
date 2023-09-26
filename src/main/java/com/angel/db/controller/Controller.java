package com.angel.db.controller;

import com.angel.db.DBM.DBM;
import com.angel.db.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static DBM dbm = new DBM();
    public static void crearProducto(String nombre, String desc, Double peso, Integer stock) {

        Product prod = new Product(nombre, desc, peso, stock);

        // BBDD
        try {
            dbm.openConnection();


        } finally {
            dbm.closeConnection();
        }
    }

    public static List<Product> obtenerListaProductos() throws SQLException {
        List<Product> listado = new ArrayList<Product>();

        ResultSet resultadoConsulta = DBM.query("SELECT * FROM productos");

        while (resultadoConsulta.next()) {
            Product elemento = new Product();

            elemento.setNombre(resultadoConsulta.getString("nombre"));
            elemento.setDescripcion(resultadoConsulta.getString("descripcion"));
            elemento.setPeso(resultadoConsulta.getDouble("peso"));
            elemento.setStock(resultadoConsulta.getInt("stock"));

            listado.add(elemento);
        }

        return listado;
    }

    public static boolean actualizarProducto() {

        return false;
    }
    }
