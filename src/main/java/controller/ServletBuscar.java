package controller;

import model.claseUsuario;
import service.metodosUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletBuscar", urlPatterns = {"/buscarUsuario"})
public class ServletBuscar extends HttpServlet {
    private metodosUsuario metodosUsuario = new metodosUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("mantenimientoUsuarioBuscar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String nombre = request.getParameter("nombreusuario");

        if (nombre == null || nombre.trim().isEmpty()) {
            request.setAttribute("mensaje", "Debe ingresar un nombre para buscar");
            request.getRequestDispatcher("mantenimientoUsuarioBuscar.jsp").forward(request, response);
            return;
        }

        List<claseUsuario> usuarios = metodosUsuario.buscarUsuarioPorNombre(nombre);

        request.setAttribute("usuarios", usuarios);
        request.setAttribute("nombreBuscado", nombre);
        request.getRequestDispatcher("mantenimientoUsuarioBuscar.jsp").forward(request, response);
    }
}