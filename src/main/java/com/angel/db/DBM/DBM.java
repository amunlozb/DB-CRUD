package com.angel.db.DBM;

import com.angel.db.model.Product;

import java.sql.*;


public class DBM {
    private static Connection connection = null;
    private static String dbName = "servlet_actividad";
    private static String dbEndpoint = "db-angel.ce8gachaetn9.eu-north-1.rds.amazonaws.com";
    private static String dbUser = "admin";
    private static String dbPassword = "rootroot";
    private static String jdbcUrl = "jdbc:mysql://" + dbEndpoint + ":3306" + "/" + dbName + "?user=" + dbUser + "&password=" + dbPassword;

    /**
     * Abrir una conexión con la BD
     */
    public void openConnection() {
        try {
            connection = DriverManager.getConnection(jdbcUrl);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("ERROR: OPENING. " + e.getMessage());
        }
    }

    /**
     * Cerrar la conexión con la BD
     */
    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println("ERROR: CLOSING. " + e.getMessage());
        }
    }

    /**
     * Retornar un ResultSet con el resultado de ejecutar una Query en la BD (tiempo máximo de espera = 30 segundos)
     */
    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("ERROR: QUERYING. " + e.getMessage());
        }
        return rs;
    }

    public boolean createRecord(Product product) throws SQLException {
        boolean res = false;

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO producto VALUES (?, ?, ?, ?)");

        preparedStatement.setString(1, product.getNombre());
        preparedStatement.setString(2, product.getDescripcion());
        preparedStatement.setDouble(3, product.getPeso());
        preparedStatement.setInt(4, product.getStock());

        preparedStatement.executeUpdate();

        return res;
    }

    public boolean updateRecord(Product product) throws SQLException {
        boolean res = false;

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO producto VALUES (?, ?, ?, ?)");

        preparedStatement.setString(1, product.getNombre());
        preparedStatement.setString(2, product.getDescripcion());
        preparedStatement.setDouble(3, product.getPeso());
        preparedStatement.setInt(4, product.getStock());

        preparedStatement.executeUpdate();

        return res;
    }

    private void updateRecord(String nombre, String newDescripcion, double newPeso, int newStock) throws SQLException {
        // Define the SQL UPDATE statement
        String updateSQL = "UPDATE your_table_name SET descripcion = ?, peso = ?, stock = ? WHERE nombre = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL) {
        preparedStatement.setString(1, newDescripcion);
        preparedStatement.setDouble(2, newPeso);
        preparedStatement.setInt(3, newStock);
        preparedStatement.setString(4, nombre);

            // Execute the UPDATE statement
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                // The update was successful
                System.out.println("Actualizacion realizada con exito.");
            } else {
                // No record with the given name was found
                System.out.println("No se encontraron productos con el nombre: " + nombre);
            }
        } catch (SQLException e) {
            // Handle any database-related exceptions
            e.printStackTrace();
        }
    }

}
