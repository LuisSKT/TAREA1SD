package service;

import data.miConexion;
import model.claseUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class metodosUsuario {
    private miConexion conexion = new miConexion();

    public boolean insertarUsuario(claseUsuario usuario) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = conexion.getConnection();
            String sql = "INSERT INTO tbusuario2 (nombreusuario, password, email, rol) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getNombreusuario());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getRol());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✓ Usuario insertado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("✗ Error insertando usuario: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conexion.cerrarConexion(conn);
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return false;
    }

    public List<claseUsuario> buscarUsuarioPorNombre(String nombre) {
        List<claseUsuario> usuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            String sql = "SELECT * FROM tbusuario2 WHERE nombreusuario LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                claseUsuario usuario = new claseUsuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNombreusuario(rs.getString("nombreusuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                usuarios.add(usuario);
            }
            System.out.println("✓ Se encontraron " + usuarios.size() + " usuarios");
        } catch (SQLException e) {
            System.err.println("✗ Error buscando usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conexion.cerrarConexion(conn);
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return usuarios;
    }

    public claseUsuario validarUsuario(String nombreusuario, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            String sql = "SELECT * FROM tbusuario2 WHERE nombreusuario = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreusuario);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                claseUsuario usuario = new claseUsuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNombreusuario(rs.getString("nombreusuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                System.out.println("✓ Login válido: " + usuario.getNombreusuario());
                return usuario;
            }
            System.out.println("✗ Login inválido");
        } catch (SQLException e) {
            System.err.println("✗ Error validando usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conexion.cerrarConexion(conn);
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
}