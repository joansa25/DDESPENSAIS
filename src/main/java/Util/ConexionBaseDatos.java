package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/desarrollo?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    /* Método estático si es nulo se conecta, si existe solo se devuelve la conexión */
    public static Connection getInstance() throws SQLException {
        // Cargar el controlador JDBC de MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el controlador JDBC de MySQL");
        }

        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
