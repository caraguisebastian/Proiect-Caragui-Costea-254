package main.java.Configs;

import java.sql.*;


public class DatabaseConnection {

    private static Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Proiect","Proiect","passproiect");

            //System.out.println("Sa facut conexiune la BD!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        if (connection == null)
            new DatabaseConnection();
        return connection;
    }



}
