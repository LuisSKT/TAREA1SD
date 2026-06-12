package controller;

import model.claseUsuario;
import service.metodosUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/crearUsuario"})
public class ServletUsuario extends HttpServlet {
    private metodosUsuario metodosUsuario = new metodosUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("mantenimientoUsuarioNuevo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String nombreusuario = request.getParameter("nombreusuario");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String rol = request.getParameter("rol");

        claseUsuario usuario = new claseUsuario();
        usuario.setNombreusuario(nombreusuario);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setRol(rol);

        boolean insertado = metodosUsuario.insertarUsuario(usuario);

        if (insertado) {
            request.setAttribute("mensaje", "Usuario creado correctamente");
            response.sendRedirect("mantenimientoUsuario.jsp");
        } else {
            request.setAttribute("mensaje", "Error creando usuario");
            request.getRequestDispatcher("mantenimientoUsuarioNuevo.jsp").forward(request, response);
        }
    }
}