<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mantenimiento de Usuarios</title>
</head>
<body>
    <div style="margin: 30px;">
        <h2>Módulo de Mantenimiento de Usuarios</h2>
        <p>Selecciona una acción para gestionar los registros de la base de datos:</p>
        <hr>

        <button onclick="location.href='regiUsuario.jsp'">➕ Registrar Nuevo Usuario</button>
        <button onclick="location.href='busUsuario.jsp'">🔍 Buscar un Usuario</button>

        <br><br>
        <a href="menuP.jsp">⬅ Volver al Menú Principal</a>
    </div>
</body>
</html>