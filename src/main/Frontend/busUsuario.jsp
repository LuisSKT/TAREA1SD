<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ClaseUsuario" %>
<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    List<ClaseUsuario> lista = (List<ClaseUsuario>) request.getAttribute("usuarios");
    String nombreBuscado = request.getAttribute("nombreBuscado") != null ? (String) request.getAttribute("nombreBuscado") : "";
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Buscar Usuarios</title>
</head>
<body>
    <div style="margin: 30px;">
        <h2>Buscar Usuarios por Nombre</h2>
        <hr>

        <form action="buscarUsuario" method="post">
            <label>Ingresa el nombre (o las primeras letras):</label><br>
            <input type="text" name="nombreusuario" value="<%= nombreBuscado %>" placeholder="Ej: Luis" required>
            <button type="submit">Buscar</button>
        </form>

        <br><br>

        <% if (lista != null) { %>
            <h3>Resultados de la búsqueda:</h3>
            <% if (!lista.isEmpty()) { %>
                <table border="1" cellpadding="8" style="border-collapse: collapse; width: 100%;">
                    <tr style="background-color: #f2f2f2;">
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Email</th>
                        <th>Rol</th>
                    </tr>
                    <% for (ClaseUsuario u : lista) { %>
                        <tr>
                            <td><%= u.getIdusuario() %></td>
                            <td><%= u.getNombreusuario() %></td>
                            <td><%= u.getEmail() %></td>
                            <td><%= u.getRol() %></td>
                        </tr>
                    <% } %>
                </table>
            <% } else { %>
                <p style="color: red;">✗ No se encontraron usuarios con ese nombre.</p>
            <% } %>
        <% } %>

        <br><br>
        <a href="manUsuario.jsp">⬅ Volver a Mantenimiento</a>
    </div>
</body>
</html>