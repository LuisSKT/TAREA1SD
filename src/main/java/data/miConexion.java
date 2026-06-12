package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class miConexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/mibase1";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                System.out.println("✓ Conexión a PostgreSQL establecida correctamente");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("✗ Driver PostgreSQL no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("✗ Error de conexión: " + e.getMessage());
        }
        return conn;
    }

    public void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✓ Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("✗ Error cerrando conexión: " + e.getMessage());
            }
        }
    }
}