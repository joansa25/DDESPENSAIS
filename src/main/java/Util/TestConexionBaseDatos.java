package Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Util.ConexionBaseDatos;

@WebServlet("/listarUsuarios")
public class TestConexionBaseDatos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionBaseDatos.getInstance();
            String query = "SELECT * FROM d_usuarios";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Listado de Usuarios</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Usuario</th><th>Password</th></tr>");

            while (resultSet.next()) {
                String usuario = resultSet.getString("usuario");
                String password = resultSet.getString("password");
                out.println("<tr><td>" + usuario + "</td><td>" + password + "</td></tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error de base de datos: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
