package com.angel.db;

import java.io.*;
import java.sql.*;

import com.angel.db.DBM.DBM;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ProcessForm", value = "/ProcessForm")
public class ProcessForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String peso = request.getParameter("peso");
        String stock = request.getParameter("stock");

        // Check if a record with the given name exists in the database
        boolean recordExists = doesRecordExist(nombre);

        if (!recordExists) {
            createRecord(nombre, descripcion, peso, stock);
        } else {
            updateRecord(nombre, descripcion, peso, stock);
        }

        // Optionally, you can redirect to a success page or show a message
        response.sendRedirect("success.jsp");
    }

    private boolean doesRecordExist(String nombre) {
        // Implement logic to check if a record with the given name exists in the database
        // You can use JDBC to query the database
        DBM dbm = new DBM();
        ResultSet res = null;
        boolean exists = false;

        try {
            dbm.openConnection();

            dbm.query("SELECT COUNT(*) FROM productos WHERE nombre = " + nombre);

            // Compruebo si el resultSet esta vacio o no

            if (res.next()) {
                int count = res.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbm.closeConnection();
        }

        return exists;
    }

    private void createRecord(String nombre, String descripcion, String peso, String stock) {
        // Implement logic to create a new record in the database

        // You can use JDBC to insert the new record
    }

    private void updateRecord(String nombre, String descripcion, String peso, String stock) {
        // Implement logic to update the existing record in the database
        // You can use JDBC to update the record
    }
}