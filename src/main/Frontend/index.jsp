<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login - TAREA1</title>
</head>
<body>
    <div style="margin: 50px auto; width: 300px; padding: 20px; border: 1px solid #ccc;">
        <h2>Iniciar Sesión</h2>

        <%-- Aquí se muestra el mensaje si el usuario o contraseña están mal --%>
        <% if(request.getAttribute("mensaje") != null) { %>
            <p style="color: red;"><%= request.getAttribute("mensaje") %></p>
        <% } %>

        <form action="login" method="post">
            <label>Usuario:</label><br>
            <input type="text" name="nombreusuario" required><br><br>

            <label>Contraseña:</label><br>
            <input type="password" name="password" required><br><br>

            <button type="submit">Ingresar</button>
        </form>
    </div>
</body>
</html>