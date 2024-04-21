/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author WHC2G
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionBaseDatos.getInstance();
            String query = "SELECT * FROM d_usuarios WHERE usuario = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Credenciales válidas
                System.out.println("Inicio de sesión exitoso para el usuario: " + username);
               response.sendRedirect("pages/vista/VISTASHTML/MENUPRINCIPAL.html");
            } else {
                // Credenciales inválidas
                System.out.println("Inicio de sesión fallido para el usuario: " + username);
                // Redirigir de vuelta al formulario de inicio de sesión
                response.sendRedirect("mostrarParametros.jsp");
            }
        } catch (SQLException e) {
            // Manejar cualquier error de base de datos aquí
            System.out.println("Error de base de datos: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                // Manejar cualquier error de cierre de recursos aquí
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}

