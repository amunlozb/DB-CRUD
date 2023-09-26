package com.angel.db.DBM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBM {
    private static Connection connection = null;
    private static String dbName = "servlet_actividad";
    private static String dbEndpoint = "db-angel.ce8gachaetn9.eu-north-1.rds.amazonaws.com";
    private static String dbUser = "admin";
    private static String dbPassword = "rootroot";
    private static String jdbcUrl = "jdbc:mysql://" + dbEndpoint + "/" + dbName + "?user=" + dbUser + "&password=" + dbPassword;

    /**
     * Abrir una conexión con la BD
     */
    public void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql:" + jdbcUrl);
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
    public static ResultSet query(String sql) {
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
}
