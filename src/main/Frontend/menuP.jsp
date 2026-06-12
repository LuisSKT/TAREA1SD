<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ClaseUsuario" %>
<%
    // Protección de sesión: si no está logueado, lo bota al login
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    String nombre = (String) session.getAttribute("nombreusuario");
    String rol = (String) session.getAttribute("rol");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menú Principal</title>
</head>
<body>
    <div style="margin: 30px; padding: 20px;">
        <h1>Bienvenido, <%= nombre %>!</h1>
        <p><strong>Rol actual:</strong> <%= rol %></p>
        <hr>

        <h3>Opciones del Sistema:</h3>
        <ul>
            <li><a href="manUsuario.jsp">Ver Mantenimiento de Usuarios</a></li>
            <li><a href="regiUsuario.jsp">Registrar Nuevo Usuario</a></li>
            <li><a href="busUsuario.jsp">Buscar Usuarios</a></li>
        </ul>

        <br>
        <%-- Apunta al ServletCierre --%>
        <a href="cerrarSesion" style="color: red; font-weight: bold;">Cerrar Sesión</a>
    </div>
</body>
</html>
</html>