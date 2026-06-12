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
    <title>Registrar Usuario</title>
</head>
<body>
    <div style="margin: 30px; width: 400px;">
        <h2>Registrar Nuevo Usuario</h2>
        <hr>

        <% if(request.getAttribute("mensaje") != null) { %>
            <p style="color: blue;"><%= request.getAttribute("mensaje") %></p>
        <% } %>

        <form action="crearUsuario" method="post">
            <label>Nombre de Usuario:</label><br>
            <input type="text" name="nombreusuario" required><br><br>

            <label>Contraseña:</label><br>
            <input type="password" name="password" required><br><br>

            <label>Correo Electrónico:</label><br>
            <input type="email" name="email" required><br><br>

            <label>Rol del Sistema:</label><br>
            <select name="rol">
                <option value="ADMIN">ADMIN</option>
                <option value="CLIENTE">CLIENTE</option>
                <option value="INVITADO">INVITADO</option>
            </select><br><br>

            <button type="submit">Guardar Usuario</button>
            <button type="button" onclick="location.href='manUsuario.jsp'">Cancelar</button>
        </form>
    </div>
</body>
</html>